package org.bakinu.rF5RussianFishing5.commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bakinu.rF5RussianFishing5.util.FishingRodManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CommandGiveFishingRod implements CommandExecutor {
    private final MiniMessage miniMessage = MiniMessage.miniMessage();
    private final FishingRodManager fishingRodManager;

    public CommandGiveFishingRod(FishingRodManager fishingRodManager) {
        this.fishingRodManager = fishingRodManager;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (!(commandSender instanceof Player player))
            return false;

        if (!(commandSender.hasPermission("rf5.giverod"))) {
            commandSender.sendMessage(miniMessage.deserialize("<italic:false><#850000> У вас нету права на использование данной комманды!"));
            return false;
        }

        if (args.length > 0) {
            String fishingRodIndex = args[0];
            try {
                ItemStack fishingRod = fishingRodManager.createRod(fishingRodManager.getFishingRodsMap().get(fishingRodIndex), player);
            } catch (CommandException e) {
                e.printStackTrace();
                player.sendMessage("Такой удочки не существует!");
            }
        } else {
            player.sendMessage("Введите индекс нужной удочки!");
        }

        return true;
    }
}
