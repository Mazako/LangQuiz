package pl.mazak.lquiz.translation;

import pl.mazak.lquiz.persistance.translation.AllowedLanguage;

import java.util.Optional;

public interface TranslationService {
    String addWord(TranslationDTO translationDTO);
    String deleteWordById(String id);
    Optional<TranslationDTO> findTranslation(AllowedLanguage language, String word);
    Optional<TranslationDTO> findTranslationById(String id);
    Optional<TranslationDTO> findTranslationById(String id, AllowedLanguage lang);
}
