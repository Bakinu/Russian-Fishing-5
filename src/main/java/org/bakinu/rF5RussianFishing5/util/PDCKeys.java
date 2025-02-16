package org.bakinu.rF5RussianFishing5.util;

import lombok.Getter;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

@Getter
public class PDCKeys {
    private Plugin plugin;

    public PDCKeys(Plugin plugin) {
        this.plugin = plugin;
        rodStatsKey = new NamespacedKey(this.plugin, "rod_stats");
    }

    NamespacedKey rodStatsKey;
}
