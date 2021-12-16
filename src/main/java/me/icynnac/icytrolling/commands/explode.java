package me.icynnac.icytrolling.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class explode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("icytroll.explode")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                assert t != null;
                World w = t.getWorld();
                if (t != null) {
                    if (args.length > 1) {
                        switch (args[1].toLowerCase()) {
                            case "1":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 1, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 1, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "2":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 2, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 2, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "3":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 3, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 3, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "4":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 4, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 4, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "5":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 5, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 5, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "6":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 6, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 6, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "7":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 7, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 7, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "8":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 8, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 8, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "9":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 9, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 9, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "10":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 10, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 10, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "11":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 11, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 11, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "12":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 12, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 12, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "13":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 13, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 13, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "14":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 14, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 14, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            case "15":
                                if (args.length > 2) {
                                    switch(args[2].toLowerCase()) {
                                        case "true":
                                            w.createExplosion(t.getLocation(), 15, true);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        case "false":
                                            w.createExplosion(t.getLocation(), 15, false);
                                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " has been blown up!");
                                            break;
                                        default:
                                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                            break;
                                    }
                                }
                                break;
                            default:
                                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
                                break;
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist, did you make a typo?");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username) (explosion power) [fire true/false]");
            }
        }
        return false;
    }
}
