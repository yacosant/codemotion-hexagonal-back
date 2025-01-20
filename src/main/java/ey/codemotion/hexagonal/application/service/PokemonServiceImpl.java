package ey.codemotion.hexagonal.application.service;

import ey.codemotion.hexagonal.application.port.in.GetPokemonQuery;
import ey.codemotion.hexagonal.application.port.out.LoadPokemonPort;
import ey.codemotion.hexagonal.domain.model.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements GetPokemonQuery {
    private final LoadPokemonPort loadPokemonPort;

    public PokemonServiceImpl(LoadPokemonPort loadPokemonPort) {
        this.loadPokemonPort = loadPokemonPort;
    }

    @Override
    public List<Pokemon> getAllPokemons() {
        return loadPokemonPort.loadAllPokemons();
    }

    @Override
    public Pokemon getPokemonById(String id) {
        return loadPokemonPort.loadPokemonById(id);
    }
}
