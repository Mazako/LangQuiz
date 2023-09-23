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
        Optional<TranslationDTO> word = translationClient.findTranslation(PL, "Dupa");
        Assertions.assertThat(word).hasValue(translationDTO);
    }

    @Test
    void shouldDeleteTranslation() {
        TranslationDTO translationDTO = new TranslationDTO(PL, EN, "Siema", "Hi");
        String id = translationClient.addWord(translationDTO);
        translationClient.deleteWordById(id);
        assertThat(translationClient.findTranslationById(id)).isEmpty();
    }

    @Test
    void shouldSearchedValueBeFirstValueInDTO() {
        translationClient.addWord(new TranslationDTO(PL, EN, "Siema", "Hi"));
        Optional<TranslationDTO> hi = translationClient.findTranslation(EN, "Hi");
        assertThat(hi).hasValue(new TranslationDTO(EN, PL, "Hi", "Siema"));
    }

}