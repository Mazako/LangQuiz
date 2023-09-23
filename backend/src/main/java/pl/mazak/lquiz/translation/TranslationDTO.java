package pl.mazak.lquiz.translation;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.mazak.lquiz.persistance.translation.AllowedLanguage;
import pl.mazak.lquiz.persistance.translation.Translation;

public record TranslationDTO(@JsonProperty("lang") AllowedLanguage lang,
                             @JsonProperty("langToTranslate") AllowedLanguage langToTranslate,
                             @JsonProperty("word") String word,
                             @JsonProperty("wordToTranslate") String wordToTranslate) {
    Translation toTranslation() {
        return new Translation(lang, langToTranslate, word, wordToTranslate);
    }

    static TranslationDTO toTranslationDTO(Translation translation) {
        return new TranslationDTO(translation.getLangA(),
                translation.getLangB(),
                translation.getWordA(),
                translation.getWordB());
    }
}
