package ey.codemotion.hexagonal.application.service;

import ey.codemotion.hexagonal.domain.model.Pokemon;
import ey.codemotion.hexagonal.domain.service.PokemonService;

import java.util.List;

public class noPokemonServiceImpl implements PokemonService {
    @Override
    public List<Pokemon> getAllPokemons() {
        return List.of();
    }

    @Override
    public Pokemon getPokemonById(String id) {
        return null;
    }
}
