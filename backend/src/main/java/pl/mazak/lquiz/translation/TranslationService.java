package pl.mazak.lquiz.translation;

import pl.mazak.lquiz.persistance.translation.AllowedLanguage;

import java.util.Optional;

public interface TranslationService {
    void addWord(TranslationDTO translationDTO);
    String deleteWordById(String id);
    Optional<TranslationDTO> findTranslationByLangAndWord(AllowedLanguage language, String word);
}
