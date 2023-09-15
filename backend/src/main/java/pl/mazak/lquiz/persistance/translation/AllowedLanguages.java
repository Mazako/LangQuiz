package pl.mazak.lquiz.persistance.translation;

public enum AllowedLanguages {
    EN("English"),
    PL("Polish");

    private final String description;

    AllowedLanguages(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
