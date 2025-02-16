package org.bakinu.rF5RussianFishing5.commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bakinu.rF5RussianFishing5.util.ConfigManager;
import org.bakinu.rF5RussianFishing5.util.FishManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandGiveFish implements CommandExecutor {
    private final FishManager fishManager;
    MiniMessage miniMessage = MiniMessage.miniMessage();

    private final ConfigManager configManager;

    public CommandGiveFish(FishManager fishManager, ConfigManager configManager) {
        this.fishManager = fishManager;
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (!(commandSender instanceof Player player))
            return false;

        if (player.hasPermission("rf5.givefish")) {
            if (args.length > 0) {
                String fishIndex = args[0];
                fishManager.createFish(configManager.getFishMap().get(fishIndex), player);
            } else {
                player.sendMessage(miniMessage.deserialize("<italic:false><#850000>Введите индекс нужной рыбы!"));
            }
        } else {
            player.sendMessage(miniMessage.deserialize("<italic:false><#850000> У вас нету права на использование данной комманды!"));
        }

        return true;
    }
}
