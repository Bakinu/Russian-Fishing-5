package org.bakinu.rF5RussianFishing5.util;


import lombok.Getter;

@Getter
public enum FishRarity {
    COMMON("<#4a4a4a><italic:false>Нередкая"),
    UNCOMMON("<#4a4a4a><italic:false>Необычная"),
    RARE("<#4a4a4a><italic:false>Редкая");

    private final String rarity;

    FishRarity(String s) {
        this.rarity = s;
    }
}