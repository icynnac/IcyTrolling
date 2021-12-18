package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.Main;
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
                                if (itemInOffHand.getType().isAir()) {
                                    sender.sendMessage(ChatColor.RED + "Target isn't holding any item in their offhand.");
                                    return false;
                                } else {
                                    sender.sendMessage(ChatColor.RED + "Target isn't holding any item in their offhand.");
                                    World w = t.getWorld();
                                    Item drop = w.dropItem(t.getLocation(), itemInOffHand);
                                    drop.setPickupDelay(40);
                                    drop.setVelocity(t.getLocation().getDirection());
                                    t.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Dropped the item in " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + "'s offhand.");
                                }
                                break;
                            case "main":
                                ItemStack itemInMainHand = t.getInventory().getItemInMainHand();
                                if (itemInMainHand.getType().isAir()) {
                                    sender.sendMessage(ChatColor.RED + "Target isn't holding any item in their offhand.");
                                    return false;
                                } else {
                                    World w = t.getWorld();
                                    Item drop = w.dropItem(t.getLocation(), itemInMainHand);
                                    drop.setPickupDelay(40);
                                    drop.setVelocity(t.getLocation().getDirection());
                                    t.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Dropped the item in " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + "'s main hand.");
                                }
                                break;
                            case "both":
                                itemInMainHand = t.getInventory().getItemInMainHand();
                                itemInOffHand = t.getInventory().getItemInOffHand();
                                World w = t.getWorld();
                                if (itemInMainHand.getType().isAir() && itemInOffHand.getType().isAir()) {
                                    sender.sendMessage(ChatColor.RED + "Target isn't holding any item.");
                                    return false;
                                } else if (itemInMainHand.getType().isAir()){
                                    Item drop = w.dropItem(t.getLocation(), itemInOffHand);
                                    drop.setPickupDelay(40);
                                    drop.setVelocity(t.getLocation().getDirection());
                                    t.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Dropped the item in " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + "'s offhand.");
                                } else if (itemInOffHand.getType().isAir()) {
                                    Item drop = w.dropItem(t.getLocation(), itemInMainHand);
                                    drop.setPickupDelay(40);
                                    drop.setVelocity(t.getLocation().getDirection());
                                    t.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Dropped the item in " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + "'s main hand.");
                                } else {
                                    Item dropm = w.dropItem(t.getLocation(), itemInMainHand);
                                    dropm.setPickupDelay(40);
                                    dropm.setVelocity(t.getLocation().getDirection());
                                    Item dropo = w.dropItem(t.getLocation(), itemInOffHand);
                                    dropo.setPickupDelay(40);
                                    dropo.setVelocity(t.getLocation().getDirection());
                                    t.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    t.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Dropped the item in both of " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + "'s hands.");
                                }
                                break;
                            default:
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmddrop));
                                break;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmddrop));
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.prefix + " " + Main.noplr));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmddrop));
            }
        }
        return false;
    }
}
