package org.bakinu.rF5RussianFishing5.util;


import lombok.Getter;

@Getter
public enum FishMutation {
    BIG("<#787878>Большая"),
    SMALL("<#404040>Маленькая");

    private String mutation;

    FishMutation(String s) {
        this.mutation = s;
    }
}
