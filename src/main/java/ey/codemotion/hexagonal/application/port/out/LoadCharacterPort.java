package ey.codemotion.hexagonal.application.port.out;

import java.util.List;
import ey.codemotion.hexagonal.domain.model.Character;

public interface LoadCharacterPort {
    List<Character> loadAllCharacters();
    Character loadCharacterById(Long id);
}
