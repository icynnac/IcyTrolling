package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.Main;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class fling implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("icytroll.fling")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        if (StringUtils.isNumeric(args[1])) {
                            if (!(Integer.parseInt(args[1]) > 4)) {
                                Location loc = t.getLocation();
                                Vector center = loc.toVector();
                                Vector toThrow = loc.toVector();
                                double x = toThrow.getX() - center.getX();
                                double z = toThrow.getZ() - center.getZ();
                                Vector v = new Vector(x, 1, z).normalize().multiply(Integer.parseInt(args[1]));
                                t.setVelocity(v);
                                sender.sendMessage(ChatColor.DARK_AQUA + "You flung " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " with a multiplier of " + ChatColor.AQUA + Integer.parseInt(args[1]) + ChatColor.DARK_AQUA + "!");
                            } else {
                                sender.sendMessage(ChatColor.RED + "Fling multiplier cannot be bigger than four.");
                            }
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmdfling));
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.prefix + " " + Main.noplr));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmdfling));
            }
        }
        return false;
    }
}
