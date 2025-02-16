package org.bakinu.rF5RussianFishing5.util;

import lombok.Getter;

@Getter
public class Fish {
    private final String name;
    private final int price;
    private final String rarity;
    private String tag;
    private final String modelType;
    private final double mass;
    private final FishMutation mutation;

    public Fish(String name, int price, String rarity, double mass, String tag, String modelType, FishMutation mutation) {
        this.name = name;
        this.price = price;
        this.rarity = rarity;
        this.mass = mass;
        this.modelType = modelType;
        this.mutation = mutation;
    }
}
