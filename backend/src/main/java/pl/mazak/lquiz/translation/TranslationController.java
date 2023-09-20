package pl.mazak.lquiz.translation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mazak.lquiz.persistance.translation.AllowedLanguage;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/translation", produces = APPLICATION_JSON_VALUE)
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = requireNonNull(translationService);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addTranslation(@RequestBody TranslationDTO translationDTO) {
        String id = translationService.addWord(translationDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleleTranslation(@PathVariable String id) {
        String deletedWord = translationService.deleteWordById(id);
        if (deletedWord == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedWord);
    }

    @GetMapping("/find")
    public ResponseEntity<TranslationDTO> getWord(@RequestParam AllowedLanguage language,
                                                  @RequestParam String word) {
        return translationService.findTranslationByLangAndWord(language, word)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
