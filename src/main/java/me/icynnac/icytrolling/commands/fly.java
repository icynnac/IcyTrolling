package me.icynnac.icytrolling.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("icytroll.levitate")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        switch (args[1].toLowerCase()) {
                            case "1":
                                if (!t.hasPotionEffect(PotionEffectType.LEVITATION)) {
                                    t.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 1));
                                    t.sendMessage(ChatColor.DARK_AQUA + "Whoops, you're going to the sun!");
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Sent " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " to the sun.");
                                } else {
                                    sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " already has levitation.");
                                }
                                break;
                            case "2":
                                if (!t.hasPotionEffect(PotionEffectType.LEVITATION)) {
                                    t.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 2));
                                    t.sendMessage(ChatColor.DARK_AQUA + "Whoops, you're going to the sun!");
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Sent " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " to the sun.");
                                } else {
                                    sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " already has levitation.");
                                }
                                break;
                            case "3":
                                if (!t.hasPotionEffect(PotionEffectType.LEVITATION)) {
                                    t.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 3));
                                    t.sendMessage(ChatColor.DARK_AQUA + "Whoops, you're going to the sun!");
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Sent " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " to the sun.");
                                } else {
                                    sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " already has levitation.");
                                }
                                break;
                            case "4":
                                if (!t.hasPotionEffect(PotionEffectType.LEVITATION)) {
                                    t.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 4));
                                    t.sendMessage(ChatColor.DARK_AQUA + "Whoops, you're going to the sun!");
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Sent " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " to the sun.");
                                } else {
                                    sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " already has levitation.");
                                }
                                break;
                            case "5":
                                if (!t.hasPotionEffect(PotionEffectType.LEVITATION)) {
                                    t.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 5));
                                    t.sendMessage(ChatColor.DARK_AQUA + "Whoops, you're going to the sun!");
                                    sender.sendMessage(ChatColor.DARK_AQUA + "Sent " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " to the sun.");
                                } else {
                                    sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " already has levitation.");
                                }
                                break;
                            case "off":
                                if (t.hasPotionEffect(PotionEffectType.LEVITATION)) {
                                    t.removePotionEffect(PotionEffectType.LEVITATION);
                                    t.sendMessage(ChatColor.DARK_AQUA + "Whoops, your falling.");
                                    sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now coming back down...");
                                } else {
                                    sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " doesn't have levitation.");
                                }
                                break;
                            default:
                                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /levitate (target's username) (effect power)");
                                break;
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist, did you make a typo?");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /levitate (target's username) (effect power)");
            }
        }
        return false;
    }
}
