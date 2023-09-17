package pl.mazak.lquiz.translation;

import pl.mazak.lquiz.persistance.translation.AllowedLanguages;
import pl.mazak.lquiz.persistance.translation.Translation;
import pl.mazak.lquiz.persistance.translation.TranslationRepository;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class TranslationService {
    private final TranslationRepository translationRepository;

    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = requireNonNull(translationRepository);
    }

    public void addWord(TranslationDTO translationDTO) {
        translationRepository.save(translationDTO.toTranslation());
    }

    public String deleteWordById(String id) {
        if (translationRepository.findById(id).isPresent()) {
            translationRepository.deleteById(id);
            return id;
        }
        return null;
    }

    public Optional<TranslationDTO> findTranslationByLangAndWord(AllowedLanguages language, String word) {
        return translationRepository.containsWordInLanguage(word, language)
                .map(TranslationDTO::toTranslationDTO);
    }
}
