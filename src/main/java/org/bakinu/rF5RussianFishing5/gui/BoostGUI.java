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
import xyz.xenondevs.invui.item.impl.SimpleItem;
import xyz.xenondevs.invui.window.Window;

public class BoostGUI extends AbstractItem {

    @Override
    public ItemProvider getItemProvider() {
        return new ItemBuilder(Material.AMETHYST_SHARD).setDisplayName("§5Магазин бустов");
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        Gui statsGui = createStatsGui(player);

        Window window = Window.single()
                .setViewer(player)
                .setGui(statsGui)
                .setTitle("Магазин бустов")
                .build();
        window.open();
    }

    private Gui createStatsGui(Player player) {
        MenuGUI menuGUI = new MenuGUI();
        Gui mainGui = menuGUI.createMainGui();
        return Gui.normal()
                .setStructure(
                        "* # # # # # # # *",
                        "# . . . . . . . #",
                        "* # # # # # # # *")
                .addIngredient('#', new SimpleItem(new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayName(" ")))
                .addIngredient('*', new ToGUI(mainGui, "Меню рыбалки"))
                .addIngredient('.', new SimpleItem(new ItemBuilder(Material.AIR)))
                .build();
    }

}
