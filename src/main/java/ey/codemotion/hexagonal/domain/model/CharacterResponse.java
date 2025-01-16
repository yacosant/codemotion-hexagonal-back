package ey.codemotion.hexagonal.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class CharacterResponse {
    private Info info;
    private List<Character> results;

    @Data
    public static class Info {
        private int count;
        private int pages;
        private String next;
        private String prev;
    }
}
