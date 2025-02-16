package org.bakinu.rF5RussianFishing5.events;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.sound.Sound.Source;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class EventPlayerFish implements Listener {
    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent event) {
        Player player = event.getPlayer();

        switch (event.getState().name()) {
            case "BITE" -> {
                ItemStack fishingRod = player.getInventory().getItemInMainHand();

                player.playSound(Sound.sound(Key.key("minecraft:entity.fish.swim"), Source.PLAYER, 1f, 1f));
                event.setCancelled(true);
            }
        }
    }
}
