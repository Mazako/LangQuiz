package pl.mazak.lquiz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import pl.mazak.lquiz.translation.TranslationClient;

@Configuration
class TestConfig {

    @Value("${server.port}")
    private int serverPort;

    @Bean
    TranslationClient translationClient() {
        return new TranslationClient(serverPort);
    }

}
