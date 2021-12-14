package me.icynnac.icytrolling.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class drop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("icytroll.drop")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        switch (args[1].toLowerCase()) {
                            case "offhand":
                                ItemStack itemInOffHand = t.getInventory().getItemInOffHand();
                                if (itemInOffHand != null) {
                                    World w = t.getWorld();
                                    Item drop = w.dropItem(t.getLocation(), itemInOffHand);
                                    drop.setPickupDelay(40);
                                    drop.setVelocity(t.getLocation().getDirection());
                                    t.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                                } else {
                                    sender.sendMessage(ChatColor.RED + "Target isn't holding any item in their offhand.");
                                }
                                break;
                            case "main":
                                ItemStack itemInMainHand = t.getInventory().getItemInMainHand();
                                if (itemInMainHand != null) {
                                    World w = t.getWorld();
                                    Item drop = w.dropItem(t.getLocation(), itemInMainHand);
                                    drop.setPickupDelay(40);
                                    drop.setVelocity(t.getLocation().getDirection());
                                    t.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                } else {
                                    sender.sendMessage(ChatColor.RED + "Target isn't holding any item in their offhand.");
                                }
                                break;
                            default:
                                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /drop (target's username) [main/offhand]");
                                break;
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /drop (target's username) [main/offhand]");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist, did you make a typo?");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /drop (target's username) [main/offhand]");
            }
        }
        return false;
    }
}
