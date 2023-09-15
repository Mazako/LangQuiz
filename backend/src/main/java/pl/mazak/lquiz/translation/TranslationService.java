package pl.mazak.lquiz.translation;

import pl.mazak.lquiz.persistance.translation.TranslationRepository;

import static java.util.Objects.requireNonNull;

public class TranslationService {
    private final TranslationRepository translationRepository;

    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = requireNonNull(translationRepository);
    }
}
