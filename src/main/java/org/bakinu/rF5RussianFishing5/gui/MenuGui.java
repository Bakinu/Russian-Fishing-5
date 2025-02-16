package org.bakinu.rF5RussianFishing5.gui;

import org.bukkit.Material;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.item.impl.SimpleItem;

import java.awt.*;

public class MenuGui {
    public Gui createGui() {
            return Gui.normal()
                    .setStructure(
                            "# # # # # # # # #",
                            "# . . . . . . . #",
                            "# . . . . . . . #",
                            "# # # # # # # # #")
                    .addIngredient('#', new SimpleItem(new ItemBuilder(Material.TNT)))
                    .addIngredient('.', new SimpleItem(new ItemBuilder(Material.DIAMOND)))
                    .build();
    }
}