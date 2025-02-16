package org.bakinu.rF5RussianFishing5.util;

import lombok.Getter;

@Getter
public class FishingRod {
    private final int luck;
    private final int lureSpeed;
    private final int maxKg;
    private final String name;
    private final String tag;

    public FishingRod(String name, int luck, int lureSpeed, int maxKg, String tag) {
        this.name = name;
        this.luck = luck;
        this.lureSpeed = lureSpeed;
        this.maxKg = maxKg;
        this.tag = tag;
    }
}
