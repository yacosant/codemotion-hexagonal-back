package ey.codemotion.hexagonal.application.port.out;

import ey.codemotion.hexagonal.domain.model.Pokemon;

import java.util.List;

public interface LoadPokemonPort {
    List<Pokemon> loadAllPokemons();
    Pokemon loadPokemonById(String id);
}
