package pl.mazak.lquiz.translation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.mazak.lquiz.persistance.translation.AllowedLanguage;

import java.util.Optional;

import static pl.mazak.lquiz.utils.ClientUtils.createUrlForPortAndPath;

public class TranslationClient implements TranslationService {
    private final int port;
    private final RestTemplate restTemplate;

    public TranslationClient(int port) {
        this.port = port;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public String addWord(TranslationDTO translationDTO) {
        ResponseEntity<String> response = restTemplate.postForEntity(createUrlForPortAndPath(port, "/translation/add"),
                translationDTO,
                String.class);
        return response.getBody();
    }

    @Override
    public String deleteWordById(String id) {
        restTemplate.delete(createUrlForPortAndPath(port, "/translation/delete/" + id));
        return id;
    }

    @Override
    public Optional<TranslationDTO> findTranslationByLangAndWord(AllowedLanguage language, String word) {
        ResponseEntity<TranslationDTO> response =  restTemplate.getForEntity(createUrlForPortAndPath(port,
                        String.format("/translation/find?language=%s&word=%s", language, word)),
                TranslationDTO.class);
        return Optional.ofNullable(response.getBody());
    }
}
