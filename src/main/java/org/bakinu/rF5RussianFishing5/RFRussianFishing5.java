package org.bakinu.rF5RussianFishing5;

import org.bakinu.rF5RussianFishing5.commands.CommandFishMenu;
import org.bakinu.rF5RussianFishing5.commands.CommandGiveFish;
import org.bakinu.rF5RussianFishing5.commands.CommandGiveFishingRod;
import org.bakinu.rF5RussianFishing5.events.EventPlayerFish;
import org.bakinu.rF5RussianFishing5.util.ConfigManager;
import org.bakinu.rF5RussianFishing5.util.FishManager;
import org.bakinu.rF5RussianFishing5.util.FishingRodManager;
import org.bakinu.rF5RussianFishing5.util.PDCKeys;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Path;

public final class RFRussianFishing5 extends JavaPlugin {
    @Override
    public void onEnable() {
        final Path configPath = getDataFolder().toPath().resolve("config.yml");
        ConfigManager configManager = new ConfigManager();
        configManager.reload(configPath);

        PDCKeys pdcKeys = new PDCKeys(this);
        FishManager fishManager = new FishManager(configManager);
        FishingRodManager fishingRodManager = new FishingRodManager(this, pdcKeys.getRodStatsKey());

        getServer().getPluginManager().registerEvents(new EventPlayerFish(fishManager, configManager), this);
        CommandGiveFishingRod commandGiveFishingRod = new CommandGiveFishingRod(fishingRodManager);
        getCommand("giverod").setExecutor(commandGiveFishingRod);

        CommandFishMenu commandFishMenu = new CommandFishMenu();
        getCommand("fishmenu").setExecutor(commandFishMenu);

        CommandGiveFish commandGiveFish = new CommandGiveFish(fishManager, configManager);
        getCommand("givefish").setExecutor(commandGiveFish);
    }

    @Override
    public void onDisable() {
    }
}
