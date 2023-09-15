package pl.mazak.lquiz.persistance.translation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Translation")
public class Translation {

    @Id
    private String id;
    private AllowedLanguages langA;
    private AllowedLanguages langB;
    private String wordA;
    private String wordB;

    public Translation(AllowedLanguages langA, AllowedLanguages langB, String wordA, String wordB) {
        this.langA = langA;
        this.langB = langB;
        this.wordA = wordA;
        this.wordB = wordB;
    }

    public String getId() {
        return id;
    }

    public AllowedLanguages getLangA() {
        return langA;
    }

    public void setLangA(AllowedLanguages langA) {
        this.langA = langA;
    }

    public AllowedLanguages getLangB() {
        return langB;
    }

    public void setLangB(AllowedLanguages langB) {
        this.langB = langB;
    }

    public String getWordA() {
        return wordA;
    }

    public void setWordA(String wordA) {
        this.wordA = wordA;
    }

    public String getWordB() {
        return wordB;
    }

    public void setWordB(String wordB) {
        this.wordB = wordB;
    }
}
