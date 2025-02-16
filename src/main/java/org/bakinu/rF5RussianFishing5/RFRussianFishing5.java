package org.bakinu.rF5RussianFishing5;

import org.bakinu.rF5RussianFishing5.commands.CommandFishMenu;
import org.bakinu.rF5RussianFishing5.commands.CommandGiveFishingRod;
import org.bakinu.rF5RussianFishing5.events.EventPlayerFish;
import org.bakinu.rF5RussianFishing5.util.PDCKeys;
import org.bukkit.plugin.java.JavaPlugin;

public final class RFRussianFishing5 extends JavaPlugin {
    @Override
    public void onEnable() {
        PDCKeys pdcKeys = new PDCKeys(this);

        getServer().getPluginManager().registerEvents(new EventPlayerFish(), this);
        CommandGiveFishingRod commandGiveFishingRod = new CommandGiveFishingRod(this, pdcKeys.getRodStatsKey());
        getCommand("giverod").setExecutor(commandGiveFishingRod);

        CommandFishMenu commandFishMenu = new CommandFishMenu();
        getCommand("fishmenu").setExecutor(commandFishMenu);
    }

    @Override
    public void onDisable() {
    }
}
