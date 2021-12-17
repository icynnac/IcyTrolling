package me.icynnac.icytrolling.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class fire implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("icytroll.burn")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        if (StringUtils.isNumeric(args[1])) {
                            t.setFireTicks(Integer.parseInt(args[1]));
                            sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " is now on fire for " + ChatColor.AQUA + args[1] + ChatColor.DARK_AQUA + " ticks.");
                        } else {
                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /burn (target's username) (time in ticks)");
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /burn (target's username) (time in ticks)");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist, did you make a typo?");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /burn (target's username) (time in ticks)");
            }
        }
        return false;
    }
}
