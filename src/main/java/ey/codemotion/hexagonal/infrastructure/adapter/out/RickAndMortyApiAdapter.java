package ey.codemotion.hexagonal.infrastructure.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import ey.codemotion.hexagonal.application.port.out.LoadCharacterPort;
import ey.codemotion.hexagonal.domain.model.Character;
import ey.codemotion.hexagonal.domain.model.CharacterResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
public class RickAndMortyApiAdapter implements LoadCharacterPort {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String apiUrl = "https://rickandmortyapi.com/api/character";

    public RickAndMortyApiAdapter(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Character> loadAllCharacters() {
        String response = restTemplate.getForObject(apiUrl, String.class);
        try {
            if (response != null && response.startsWith("{")) {
                CharacterResponse characterResponse = objectMapper.readValue(response, CharacterResponse.class);
                return characterResponse.getResults();
            } else {
                throw new RuntimeException("Unexpected response format: " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse response", e);
        }
    }

    @Override
    public Character loadCharacterById(Long id) {
        String url = apiUrl + "/" + id;
        return restTemplate.getForObject(url, Character.class);
    }
}
