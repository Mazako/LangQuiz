package pl.mazak.lquiz.persistance.translation;

public enum AllowedLanguage {
    EN("English"),
    PL("Polish");

    private final String description;

    AllowedLanguage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
