package dev.vacariu.customnameplatesaddon;

import net.momirealms.customnameplates.api.event.BubblesSpawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BubbleEvent implements Listener {

    private final CustomNameplatesAddon pl;

    public BubbleEvent(CustomNameplatesAddon pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onBubbleSpawn(BubblesSpawnEvent e) {
        boolean isCNMMessage = e.getText().contains("CustomNameplatesMessage ");
        if (!isCNMMessage) {
            e.setCancelled(true);
            return;
        }
        e.setText(e.getText().replace("CustomNameplatesMessage ", ""));
    }
}
