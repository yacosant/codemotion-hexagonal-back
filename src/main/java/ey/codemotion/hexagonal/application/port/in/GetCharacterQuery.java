package ey.codemotion.hexagonal.application.port.in;

import java.util.List;
import ey.codemotion.hexagonal.domain.model.Character;

public interface GetCharacterQuery {
    List<Character> getAllCharacters();
    Character getCharacterById(Long id);
}