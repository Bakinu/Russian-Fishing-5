package org.bakinu.rF5RussianFishing5.events;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.sound.Sound.Source;
import org.bakinu.rF5RussianFishing5.util.FishManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class EventPlayerFish implements Listener {
    private FishManager fishManager;

    public EventPlayerFish(FishManager fishManager) {
        this.fishManager = fishManager;
    }

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent event) {
        Player player = event.getPlayer();

        if (event.getState().name().equals("BITE")) {
            ItemStack fishingRod = player.getInventory().getItemInMainHand();

            fishManager.createFish(fishManager.getFishMap().get("Salmon"), player);

            player.playSound(Sound.sound(Key.key("minecraft:entity.fish.swim"), Source.PLAYER, 1f, 1f));
            event.getHook().remove();
            event.setCancelled(true);
        }
    }
}
