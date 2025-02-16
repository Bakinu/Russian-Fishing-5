package org.bakinu.rF5RussianFishing5.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.window.Window;

public class ToGUI extends AbstractItem {

    private final Gui targetGui; // GUI, на которое нужно перейти
    private final String title;   // Название окна

    public ToGUI(Gui targetGui, String title) {
        this.targetGui = targetGui;
        this.title = title;
    }

    @Override
    public ItemProvider getItemProvider() {
        return new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§cНазад");
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        Window window = Window.single()
                .setViewer(player)
                .setGui(targetGui)
                .setTitle(title)
                .build();
        window.open();
    }
}