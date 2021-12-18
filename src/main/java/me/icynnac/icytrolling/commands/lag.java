package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;

public class lag implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("icytroll.lag")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                        switch (args[1].toLowerCase()) {
                            case "1":
                                int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20);
                                break;
                            case "2":
                                onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*2);
                                break;
                            case "3":
                                onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*3);
                                break;
                            case "4":
                                onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*4);
                                break;
                            case "5":
                                onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*5);
                                break;
                            case "6":
                                onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*6);
                                break;
                            case "7":
                                onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*7);
                                break;
                            case "8":
                                onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*8);
                                break;
                            case "9":
                                onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*9);
                                break;
                            case "10":
                                onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, 3);
                                sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*10);
                                break;
                            default:
                                sender.sendMessage(ChatColor.RED + "Invalid time, maximum lag time is 10s.");
                                break;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmdlag));
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.prefix + " " + Main.noplr));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmdlag));
            }
        }
        return false;
    }
}