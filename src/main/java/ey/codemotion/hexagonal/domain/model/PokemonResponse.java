package ey.codemotion.hexagonal.domain.model;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PokemonResponse {
    private List<PokemonData> data;
    private int page;
    private int pageSize;
    private int count;
    private int totalCount;

    @Data
    public static class PokemonData {
        private String id;
        private String name;
        private String supertype;
        private List<String> subtypes;
        private String hp;
        private List<String> types;
        private String evolvesFrom;
        private List<String> evolvesTo;
        private List<String> rules;
        private List<Attack> attacks;
        private List<Weakness> weaknesses;
        private List<String> retreatCost;
        private int convertedRetreatCost;
        private Set set;
        private String number;
        private String artist;
        private String rarity;
        private List<Integer> nationalPokedexNumbers;
        private Legalities legalities;
        private String regulationMark;
        private Images images;
        private TcgPlayer tcgplayer;
        private CardMarket cardmarket;

        @Data
        public static class Attack {
            private String name;
            private List<String> cost;
            private int convertedEnergyCost;
            private String damage;
            private String text;
        }

        @Data
        public static class Weakness {
            private String type;
            private String value;
        }

        @Data
        public static class Set {
            private String id;
            private String name;
            private String series;
            private int printedTotal;
            private int total;
            private Legalities legalities;
            private String ptcgoCode;
            private String releaseDate;
            private String updatedAt;
            private Images images;

            @Data
            public static class Images {
                private String symbol;
                private String logo;
            }
        }

        @Data
        public static class Legalities {
            private String unlimited;
            private String expanded;
            private String standard;
        }

        @Data
        public static class Images {
            private String small;
            private String large;
        }

        @Data
        public static class TcgPlayer {
            private String url;
            private String updatedAt;
            private Prices prices;

            @Data
            public static class Prices {
                private Price holofoil;

                @Data
                public static class Price {
                    private double low;
                    private double mid;
                    private double high;
                    private double market;
                    private double directLow;
                }
            }
        }

        @Data
        public static class CardMarket {
            private String url;
            private String updatedAt;
            private Prices prices;

            @Data
            public static class Prices {
                private double averageSellPrice;
                private double lowPrice;
                private double trendPrice;
                private double germanProLow;
                private double suggestedPrice;
                private double reverseHoloSell;
                private double reverseHoloLow;
                private double reverseHoloTrend;
                private double lowPriceExPlus;
                private double avg1;
                private double avg7;
                private double avg30;
                private double reverseHoloAvg1;
                private double reverseHoloAvg7;
                private double reverseHoloAvg30;
            }
        }
    }

    public List<Pokemon> toPokemonList() {
        return data.stream().map(pokemonData -> {
            Pokemon pokemon = new Pokemon();
            pokemon.setId(pokemonData.getId());
            pokemon.setNationalPokedexNumbers(pokemonData.getNationalPokedexNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            pokemon.setType(String.join(", ", pokemonData.getTypes()));
            pokemon.setHp(pokemonData.getHp());
            pokemon.setAttack(pokemonData.getAttacks().stream()
                    .map(attack -> attack.getName() + " (" + attack.getDamage() + ")")
                    .collect(Collectors.joining(", ")));
            pokemon.setRule(String.join(", ", pokemonData.getRules()));
            pokemon.setSetSeries(pokemonData.getSet().getSeries());
            pokemon.setRarity(pokemonData.getRarity());
            pokemon.setImage(pokemonData.getImages().getLarge());
            return pokemon;
        }).collect(Collectors.toList());
    }
}