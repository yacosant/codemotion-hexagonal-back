package ey.codemotion.hexagonal.domain.service;

import java.util.List;

public interface CharacterService {
    List<Character> getAllCharacters();
    Character getCharacterById(Long id);
}
