package org.bakinu.rF5RussianFishing5.util;

import lombok.Getter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@Getter
public final class FishManager {
    private ConfigManager configManager;

    public FishManager(ConfigManager configManager) {
        this.configManager = configManager;
    }

    private final MiniMessage miniMessage = MiniMessage.miniMessage();

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