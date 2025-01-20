package ey.codemotion.hexagonal.application.port.in;

import ey.codemotion.hexagonal.domain.model.Pokemon;

import java.util.List;

public interface GetPokemonQuery {
    List<Pokemon> getAllPokemons();
    Pokemon getPokemonById(String id);
}