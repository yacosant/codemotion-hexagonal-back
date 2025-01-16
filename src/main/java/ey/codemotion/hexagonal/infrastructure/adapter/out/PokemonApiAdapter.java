package ey.codemotion.hexagonal.infrastructure.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import ey.codemotion.hexagonal.application.port.out.LoadPokemonPort;
import ey.codemotion.hexagonal.domain.model.Pokemon;
import ey.codemotion.hexagonal.domain.model.PokemonResponse;
import ey.codemotion.hexagonal.domain.model.SinglePokemonResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
public class PokemonApiAdapter implements LoadPokemonPort {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String apiUrl = "https://api.pokemontcg.io/v2/cards";

    public PokemonApiAdapter(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Pokemon> loadAllPokemons() {
        String url = apiUrl + "?page=1&pageSize=50&orderBy=number&q=nationalPokedexNumbers:[1 TO 251] subtypes:vmax";
        String response = restTemplate.getForObject(url, String.class);
        try {
            if (response != null && response.startsWith("{")) {
                PokemonResponse pokemonResponse = objectMapper.readValue(response, PokemonResponse.class);
                return pokemonResponse.toPokemonList();
            } else {
                throw new RuntimeException("Unexpected response format: " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse response", e);
        }
    }

    public Pokemon loadPokemonById(String id) {
        try {
            String response = restTemplate.getForObject(apiUrl + "/" + id, String.class);
            SinglePokemonResponse singlePokemonResponse = objectMapper.readValue(response, SinglePokemonResponse.class);
            return singlePokemonResponse.toPokemon();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse response", e);
        }
    }
}
