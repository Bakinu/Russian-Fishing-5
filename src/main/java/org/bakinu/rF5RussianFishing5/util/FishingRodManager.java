package org.bakinu.rF5RussianFishing5.util;

import lombok.Getter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class FishingRodManager {
    private final Map<String, FishingRod> fishingRodsMap = new HashMap<>(){{
       put("BrokenRod", new FishingRod("<#363535>Сломанная удочка", 1, 1, 5, "broken_rod"));
       put("BasicRod", new FishingRod("<#595959>Базовая удочка", 2, 2, 13, "basic_rod"));
       put("IronRod", new FishingRod("<#4a7dff>Железная удочка", 4, 5, 32, "iron_rod"));
       put("BoneRod", new FishingRod("<#fffdc4>Костяная удочка", 5, 8, 28, "bone_rod"));
       put("AmethystRod", new FishingRod("<#ac3af2>Аметистовая удочка", 8, 9, 47, "amethyst_rod"));
       put("BlazeRod", new FishingRod("<#ffa51f>Ифритовая удочка", 14, 7, 72, "blaze_rod"));
       put("SculkRod", new FishingRod("<#4640f5>Скалковая удочка", 20, 12, 156, "sculk_rod"));
    }};

    private Plugin plugin;
    NamespacedKey key;

    public FishingRodManager(Plugin plugin, NamespacedKey key) {
        this.key = key;
        this.plugin = plugin;
    }

    public ItemStack createRod(FishingRod fishingRod, Player player) {
        MiniMessage miniMessage = MiniMessage.miniMessage();

        ItemStack itemStack = new ItemStack(Material.FISHING_ROD, 1);

        itemStack.editMeta(meta -> {
            meta.getPersistentDataContainer().set(key, PersistentDataType.LIST.integers(), List.of(fishingRod.getLureSpeed(), fishingRod.getLuck(), fishingRod.getMaxKg()));
            meta.itemName(miniMessage.deserialize(fishingRod.getName()));
            meta.lore(List.of(miniMessage.deserialize("<italic:false><#197cb5>Скорость приманки: " + "<#2ba0e3>" + fishingRod.getLureSpeed()),
                    miniMessage.deserialize("<italic:false><#2bc429>Удача: " + "<#4fff4d>" + fishingRod.getLuck()),
                    miniMessage.deserialize("<italic:false><#e0aa22>Максимальный вес рыбы: " + "<#fac339>" + fishingRod.getMaxKg())
            ));
        });
        player.getInventory().addItem(itemStack);
        player.sendMessage(String.valueOf(itemStack.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.LIST.integers())));
        player.sendMessage(miniMessage.deserialize("<italic:false><#54ffff>Вам успешно выдана удочка: " + fishingRod.getName() + ". <#54ffff>Её статистика <hover:show_text:'" + "<#e0aa22>Максимальный вес рыбы: " + "<#fac339>" + fishingRod.getMaxKg() + "<newline>" + "<italic:false><#197cb5>Скорость приманки: " + "<#2ba0e3>" + fishingRod.getLureSpeed() + "<newline>" + "<italic:false><#2bc429>Удача: " + "<#4fff4d>" + fishingRod.getLuck() + "'> <bold:true><#7ef2f2>тут"));

        return itemStack;
    }
}
