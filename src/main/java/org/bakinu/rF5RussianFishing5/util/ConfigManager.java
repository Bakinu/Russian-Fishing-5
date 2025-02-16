package org.bakinu.rF5RussianFishing5.util;

import lombok.Getter;
import net.elytrium.serializer.SerializerConfig;
import net.elytrium.serializer.language.object.YamlSerializable;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ConfigManager extends YamlSerializable {
    private static final SerializerConfig CONFIG = new SerializerConfig.Builder().build();

    public ConfigManager() {
        super(ConfigManager.CONFIG);
    }
    public Map<String, Fish> fishMap = new HashMap<String, Fish>(){{
        put("Salmon", new Fish("<#474747>Обычный Лосось", 10, FishRarity.COMMON, 1.4, "salmon", "SALMON", FishMutation.NON_MUTATED));
        put("BigSalmon", new Fish("<#474747>Большой Лосось", 10, FishRarity.UNCOMMON, 2.1, "big_salmon", "SALMON", FishMutation.BIG));
        put("SmallSalmon", new Fish("<#474747>Маленький Лосось", 10, FishRarity.COMMON, 2.1, "small_salmon", "SALMON", FishMutation.SMALL));
        put("Fatiks", new Fish("<#474747>Фатикс", 10, FishRarity.RARE, 2.1, "fatiks", "COD", FishMutation.NON_MUTATED));
    }};
}