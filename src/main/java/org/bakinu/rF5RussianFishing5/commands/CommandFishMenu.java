package org.bakinu.rF5RussianFishing5.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.SimpleItem;
import xyz.xenondevs.invui.window.Window;

public class CommandFishMenu implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Gui gui = createGui();

            // Открываем GUI для игрока
            Window window = Window.single()
                    .setViewer(player)
                    .setGui(gui)
                    .setTitle("Меню рыбалки")
                    .build();
            window.open();
            return true;
        } else {
            sender.sendMessage("Эта команда доступна только игрокам!");
            return false;
        }
    }

    // Метод для создания GUI
    private Gui createGui() {
        return Gui.normal()
                .setStructure(
                        "# # # # # # # # #",
                        "# . . . . . . . #",
                        "# . . . . . . . #",
                        "# # # # # # # # #")
                .addIngredient('#', new SimpleItem(new ItemBuilder(Material.TNT))) // Границы из TNT
                .addIngredient('.', new SimpleItem(new ItemBuilder(Material.DIAMOND))) // Внутренние блоки из алмазов
                .build();
    }
}