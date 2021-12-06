package me.icynnac.icytrolling.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class fling implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.fling")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    Location loc = t.getLocation();
                    Vector center = loc.toVector();
                    Vector toThrow = loc.toVector();
                    double x = toThrow.getX() - center.getX();
                    double z = toThrow.getZ() - center.getZ();
                    Vector v = new Vector(x, 1, z).normalize().multiply(3);
                    t.setVelocity(v);
                    sender.sendMessage(ChatColor.DARK_AQUA + "You flung " + ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + "!");
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist, did you make a typo?");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /fling (target's username)");
            }
        }
        return false;
    }
}
