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
                        if (args[1].equalsIgnoreCase("1s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20);
                        } else if (args[1].equalsIgnoreCase("2s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*2);
                        } else if (args[1].equalsIgnoreCase("3s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*3);
                        } else if (args[1].equalsIgnoreCase("4s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*4);
                        } else if (args[1].equalsIgnoreCase("5s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*5);
                        } else if (args[1].equalsIgnoreCase("6s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*6);
                        } else if (args[1].equalsIgnoreCase("7s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*7);
                        } else if (args[1].equalsIgnoreCase("8s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*8);
                        } else if (args[1].equalsIgnoreCase("9s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*9);
                        } else if (args[1].equalsIgnoreCase("10s")) {
                            int onesec = scheduler.scheduleSyncRepeatingTask(Main.instance, () -> t.teleport(t.getLocation()),0, Main.instance.getConfig().getInt("commands.lag-loop-time"));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now lagging!");
                            scheduler.scheduleSyncDelayedTask(Main.instance, () -> scheduler.cancelTask(onesec),20*10);
                        } else {
                            sender.sendMessage(ChatColor.RED + "Invalid time, maximum lag time is 10s.");
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist, did you make a typo?");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /lag (target's username) (time)");
            }
        }
        return false;
    }
}