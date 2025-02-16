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
        put("Salmon", new Fish("<#474747>Обычный Лосось", 10, FishRarity.COMMON, 1.4, "salmon", "SALMON", FishMutation.NON_MUTAED));
        put("BigSalmon", new Fish("<#474747>Большой Лосось", 10, FishRarity.UNCOMMON, 2.1, "big_salmon", "SALMON", FishMutation.BIG));
        put("SmallSalmon", new Fish("<#474747>Маленький Лосось", 10, FishRarity.COMMON, 2.1, "small_salmon", "SALMON", FishMutation.SMALL));
    }};

    public void createFish(Fish fish, Player player) {
        ItemStack itemStack = new ItemStack(Material.getMaterial(fish.getModelType()));
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.itemName(miniMessage.deserialize("<italic:false>" + fish.getName()));

        itemMeta.lore(List.of(miniMessage.deserialize("<italic:false><#ffbc03>Стоимость: " + "<#ffcb3d>" + fish.getPrice()),
                miniMessage.deserialize("<italic:false><#ff270f>Масса рыбы: " + "<#ff412b>" +  fish.getMass() + "кг"),
                miniMessage.deserialize("<italic:false>" + fish.getMutation().getMutation()),
                miniMessage.deserialize(fish.getRarity().getRarity())
        ));

        itemStack.setItemMeta(itemMeta);
        player.sendMessage(miniMessage.deserialize("<italic:false><#54ffff>Вам успешно выдана рыба: " + fish.getName() + ". <#54ffff>Её статистика <hover:show_text:'" + "<#ffbc03>Цена: " + "<#fac339>" + fish.getPrice() + "<newline>" + "<italic:false><#197cb5>Мутация: " + "<#2ba0e3>" + fish.getMutation().getMutation() + "<newline>" + "<italic:false><#ff270f>Вес: " + "<#4fff4d>" + fish.getMass() + "кг" + "'> <bold:true><#7ef2f2>тут"));
        player.getInventory().addItem(itemStack);
    }

    //public void chooseRandomFish() {

    //}
}