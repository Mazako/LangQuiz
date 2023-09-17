package pl.mazak.lquiz.persistance.translation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TranslationRepository extends MongoRepository<Translation, String> {

    @Query("{$or: [ {langA: ?1, wordA: ?0}, {langB: ?1, wordB: ?0} ]}")
    Optional<Translation> containsWordInLanguage(String word, AllowedLanguages allowedLanguage);

}
