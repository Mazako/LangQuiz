package pl.mazak.lquiz.translation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mazak.lquiz.persistance.translation.TranslationRepository;

@Configuration
public class TranslationConfig {

    @Bean
    public TranslationService translationService(TranslationRepository translationRepository) {
        return new TranslationServiceImpl(translationRepository);
    }
}
