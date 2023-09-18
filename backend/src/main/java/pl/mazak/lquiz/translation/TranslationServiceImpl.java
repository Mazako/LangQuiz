package pl.mazak.lquiz.translation;

import pl.mazak.lquiz.persistance.translation.AllowedLanguages;
import pl.mazak.lquiz.persistance.translation.TranslationRepository;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class TranslationServiceImpl implements TranslationService {
    private final TranslationRepository translationRepository;

    public TranslationServiceImpl(TranslationRepository translationRepository) {
        this.translationRepository = requireNonNull(translationRepository);
    }
    @Override
    public void addWord(TranslationDTO translationDTO) {
        translationRepository.save(translationDTO.toTranslation());
    }

    @Override
    public String deleteWordById(String id) {
        if (translationRepository.findById(id).isPresent()) {
            translationRepository.deleteById(id);
            return id;
        }
        return null;
    }

    @Override
    public Optional<TranslationDTO> findTranslationByLangAndWord(AllowedLanguages language, String word) {
        return translationRepository.containsWordInLanguage(word, language)
                .map(TranslationDTO::toTranslationDTO);
    }
}
