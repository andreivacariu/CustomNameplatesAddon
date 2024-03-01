package dev.vacariu.customnameplatesaddon;


import net.momirealms.customnameplates.api.mechanic.bubble.Bubble;
import net.momirealms.customnameplates.api.mechanic.character.ConfiguredChar;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BubbleCommand implements CommandExecutor {
    private final CustomNameplatesAddon pl;

    public BubbleCommand(CustomNameplatesAddon pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("me")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GOLD + "[CustomNameplatesAddon] " + ChatColor.GRAY + "Use " + ChatColor.YELLOW + "/me <message>" + ChatColor.GRAY + " to send a message!");
                return true;
            } else {
                StringBuilder message = new StringBuilder();
                message.append("CustomNameplatesMessage");
                for (String str : args) {
                    if (!str.equalsIgnoreCase("me")) message.append(" ").append(str);
                }
                pl.customNameplatesPlugin.getScheduler().runTaskAsync(() -> pl.bubbleManager.onChat((Player) sender, message.toString()));
                return true;
            }
        }

        sender.sendMessage(ChatColor.GOLD + "[CustomNameplatesAddon] " + ChatColor.RED + "This is not a valid command.");
        return true;
    }
}

