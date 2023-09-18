package pl.mazak.lquiz.migration;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import pl.mazak.lquiz.persistance.translation.Translation;
import pl.mazak.lquiz.persistance.translation.TranslationRepository;

import java.util.List;

import static pl.mazak.lquiz.persistance.translation.AllowedLanguage.EN;
import static pl.mazak.lquiz.persistance.translation.AllowedLanguage.PL;

@ChangeUnit(id="createTranslationCollectionAndAddSampleData", order = "001", author = "Mazak")
public class V001CreateTranslationCollectionAndAddSampleData {

    @Execution
    public void execution(TranslationRepository translationRepository) {
        translationRepository.saveAll(List.of(
                new Translation(EN, PL, "Hello", "Cześć"),
                new Translation(EN, PL, "Good", "Dobrze")));
    }

    @RollbackExecution
    public void rollback() {
        // Noop
    }

}
