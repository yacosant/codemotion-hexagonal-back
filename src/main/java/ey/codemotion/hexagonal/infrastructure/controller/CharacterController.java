package ey.codemotion.hexagonal.infrastructure.controller;

import ey.codemotion.hexagonal.application.port.in.GetCharacterQuery;
import ey.codemotion.hexagonal.domain.model.Character;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
@Tag(name = "Characters", description = "API for Rick and Morty characters")
public class CharacterController {

    private final GetCharacterQuery getCharacterQuery;

    public CharacterController(GetCharacterQuery getCharacterQuery) {
        this.getCharacterQuery = getCharacterQuery;
    }

    @GetMapping
    @CrossOrigin
    @Operation(summary = "Get all characters", description = "Returns a list of all characters")
    public List<Character> getAllCharacters() {
        return getCharacterQuery.getAllCharacters();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    @Operation(summary = "Get character by ID", description = "Returns a character by their ID")
    public Character getCharacterById(@PathVariable Long id) {
        return getCharacterQuery.getCharacterById(id);
    }
}
