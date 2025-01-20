package ey.codemotion.hexagonal.infrastructure.controller;

import ey.codemotion.hexagonal.application.port.in.GetPokemonQuery;
import ey.codemotion.hexagonal.domain.model.Pokemon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
@Tag(name = "Pokemons", description = "API for Pokemons")
public class PokemonController {

    private final GetPokemonQuery getPokemonQuery;

    public PokemonController(GetPokemonQuery getPokemonQuery) {
        this.getPokemonQuery = getPokemonQuery;
    }

    @GetMapping
    @CrossOrigin
    @Operation(summary = "Get all Pokemons", description = "Returns a list of all Pokemons")
    public List<Pokemon> getAllPokemons() {
        return getPokemonQuery.getAllPokemons();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    @Operation(summary = "Get Pokemon by ID", description = "Returns a Pokemon by their ID")
    public Pokemon getPokemonById(@PathVariable String id) {
        return getPokemonQuery.getPokemonById(id);
    }
}
