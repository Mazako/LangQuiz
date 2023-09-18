package pl.mazak.lquiz.translation;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.mazak.lquiz.persistance.translation.AllowedLanguage;
import pl.mazak.lquiz.persistance.translation.Translation;

public record TranslationDTO(@JsonProperty("langA") AllowedLanguage langA,
                             @JsonProperty("langB") AllowedLanguage langB,
                             @JsonProperty("wordA") String wordA,
                             @JsonProperty("wordB") String wordB) {
    Translation toTranslation() {
        return new Translation(langA, langB, wordA, wordB);
    }

    static TranslationDTO toTranslationDTO(Translation translation) {
        return new TranslationDTO(translation.getLangA(),
                translation.getLangB(),
                translation.getWordA(),
                translation.getWordB());
    }
}
