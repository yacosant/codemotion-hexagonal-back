package ey.codemotion.hexagonal.application.service;

import ey.codemotion.hexagonal.application.port.in.GetCharacterQuery;
import ey.codemotion.hexagonal.application.port.out.LoadCharacterPort;
import ey.codemotion.hexagonal.domain.model.Character;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements GetCharacterQuery {
    private final LoadCharacterPort loadCharacterPort;

    public CharacterServiceImpl(LoadCharacterPort loadCharacterPort) {
        this.loadCharacterPort = loadCharacterPort;
    }

    @Override
    public List<Character> getAllCharacters() {
        return loadCharacterPort.loadAllCharacters();
    }

    @Override
    public Character getCharacterById(Long id) {
        return loadCharacterPort.loadCharacterById(id);
    }
}
