package org.bakinu.rF5RussianFishing5.util;

import lombok.Getter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class FishManager {
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    private final Map<String, Fish> fishMap = new HashMap<>(){{
        put("Salmon", new Fish("<#474747>Лосось", 10, "<#4a4a4a><italic:false>Обычная", 1.4, "salmon", "SALMON", null));
        put("BigSalmon", new Fish("<#474747>Большой Лосось", 10, "<#4a4a4a><italic:false>Обычная", 2.1, "big_salmon", "SALMON", FishMutation.BIG));
        put("SmallSalmon", new Fish("<#474747>Маленький Лосось", 10, "<#4a4a4a><italic:false>Обычная", 2.1, "small_salmon", "SALMON", FishMutation.SMALL));
    }};

    public void createFish(Fish fish, Player player) {
        ItemStack itemStack = new ItemStack(Material.getMaterial(fish.getModelType()));
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.itemName(miniMessage.deserialize("<italic:false>" + fish.getName()));

        itemMeta.lore(List.of(miniMessage.deserialize("<italic:false><#ffbc03>Стоимость: " + "<#ffcb3d>" + fish.getPrice()),
                miniMessage.deserialize("<italic:false><#ff270f>Масса рыбы: " + "<#ff412b>" +  fish.getMass() + "кг"),
                miniMessage.deserialize("<italic:false>" + fish.getMutation().getMutation()),
                miniMessage.deserialize(fish.getRarity())
                ));

        itemStack.setItemMeta(itemMeta);
        player.getInventory().addItem(itemStack);
    }

    public void chooseRandomFish() {

    }
}