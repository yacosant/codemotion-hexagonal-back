package ey.codemotion.hexagonal.domain.service;

import ey.codemotion.hexagonal.domain.model.Pokemon;

import java.util.List;

public interface PokemonService {
    List<Pokemon> getAllPokemons();
    Pokemon getPokemonById(String id);
}
