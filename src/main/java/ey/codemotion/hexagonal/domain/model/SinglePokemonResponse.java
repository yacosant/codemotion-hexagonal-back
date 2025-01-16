package ey.codemotion.hexagonal.domain.model;

import lombok.Data;

import java.util.stream.Collectors;

@Data
public class SinglePokemonResponse {
    private PokemonResponse.PokemonData data;

    public Pokemon toPokemon() {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(data.getId());
        pokemon.setNationalPokedexNumbers(data.getNationalPokedexNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        pokemon.setType(String.join(", ", data.getTypes()));
        pokemon.setHp(data.getHp());
        pokemon.setAttack(data.getAttacks().stream()
                .map(attack -> attack.getName() + " (" + attack.getDamage() + ")")
                .collect(Collectors.joining(", ")));
        pokemon.setRule(String.join(", ", data.getRules()));
        pokemon.setSetSeries(data.getSet().getSeries());
        pokemon.setRarity(data.getRarity());
        pokemon.setImage(data.getImages().getLarge());
        return pokemon;
    }
}
