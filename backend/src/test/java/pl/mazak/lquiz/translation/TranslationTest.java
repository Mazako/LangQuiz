package pl.mazak.lquiz.translation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.mazak.lquiz.TestWithMongoDB;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.mazak.lquiz.persistance.translation.AllowedLanguage.EN;
import static pl.mazak.lquiz.persistance.translation.AllowedLanguage.PL;

class TranslationTest extends TestWithMongoDB {

    @Autowired
    private TranslationClient translationClient;

    @Test
    void shouldAddAnyWord() {
        String id = translationClient.addWord(new TranslationDTO(PL, EN, "Dupa", "Ass"));
        assertThat(id).isNotNull();
    }

    @Test
    void shouldFindWordReturnValues() {
        TranslationDTO translationDTO = new TranslationDTO(PL, EN, "Dupa", "Ass");
        translationClient.addWord(translationDTO);
        Optional<TranslationDTO> word = translationClient.findTranslationByLangAndWord(EN, "Ass");
        Assertions.assertThat(word).hasValue(translationDTO);
    }

}