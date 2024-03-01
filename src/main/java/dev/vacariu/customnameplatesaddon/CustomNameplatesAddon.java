package dev.vacariu.customnameplatesaddon;

import net.momirealms.customnameplates.api.CustomNameplatesPlugin;
import net.momirealms.customnameplates.api.manager.BubbleManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomNameplatesAddon extends JavaPlugin {

    BubbleManager bubbleManager;
    CustomNameplatesPlugin customNameplatesPlugin;
    @Override
    public void onEnable() {
        bubbleManager = CustomNameplatesPlugin.get().getBubbleManager();
        customNameplatesPlugin = CustomNameplatesPlugin.get();
        getCommand("me").setExecutor(new BubbleCommand(this));
        getServer().getPluginManager().registerEvents(new BubbleEvent(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
