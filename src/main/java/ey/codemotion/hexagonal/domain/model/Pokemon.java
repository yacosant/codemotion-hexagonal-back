package ey.codemotion.hexagonal.domain.model;

import lombok.Data;
import java.util.List;

@Data
public class Pokemon {
    private String id;
    private String nationalPokedexNumbers;
    private String type;
    private String hp;
    private String attack;
    private String rule;
    private String setSeries;
    private String rarity;
    private String image;
}
