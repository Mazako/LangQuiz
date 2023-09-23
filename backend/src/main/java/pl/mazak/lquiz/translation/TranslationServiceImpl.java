package pl.mazak.lquiz.translation;

import pl.mazak.lquiz.persistance.translation.AllowedLanguage;
import pl.mazak.lquiz.persistance.translation.Translation;
import pl.mazak.lquiz.persistance.translation.TranslationRepository;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class TranslationServiceImpl implements TranslationService {
    private final TranslationRepository translationRepository;

    public TranslationServiceImpl(TranslationRepository translationRepository) {
        this.translationRepository = requireNonNull(translationRepository);
    }
    @Override
    public String addWord(TranslationDTO translationDTO) {
        return translationRepository.save(translationDTO.toTranslation())
                .getId();
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
    public Optional<TranslationDTO> findTranslation(AllowedLanguage language, String word) {
        return translationRepository.containsWordInLanguage(word, language)
                .map(translation -> createAndDetermineByLang(translation, language));
    }

    @Override
    public Optional<TranslationDTO> findTranslationById(String id) {
        return findTranslationById(id, null);
    }

    @Override
    public Optional<TranslationDTO> findTranslationById(String id, AllowedLanguage lang) {
        return translationRepository.findById(id)
                .filter(l -> lang != null)
                .map(translation -> createAndDetermineByLang(translation, lang));

    }

    private TranslationDTO createAndDetermineByLang(Translation translation, AllowedLanguage language) {
        if (translation.getLangA() == language) {
            return new TranslationDTO(translation.getLangA(),
                    translation.getLangB(),
                    translation.getWordA(),
                    translation.getWordB());
        }
        else if (translation.getLangB() == language) {
            return new TranslationDTO(translation.getLangB(),
                    translation.getLangA(),
                    translation.getWordB(),
                    translation.getWordA());
        }
        throw new IllegalArgumentException("Searched language is not present in translation");
    }


}
