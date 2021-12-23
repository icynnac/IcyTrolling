package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.utils.InvalidCommand;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdFling implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.fling")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        if (StringUtils.isNumeric(args[1])) {
                            if (0 < Integer.parseInt(args[1]) && Integer.parseInt(args[1]) < 5) {
                                Location loc = t.getLocation();
                                Vector center = loc.toVector();
                                Vector toThrow = loc.toVector();
                                double x = toThrow.getX() - center.getX();
                                double z = toThrow.getZ() - center.getZ();
                                Vector v = new Vector(x, 1, z).normalize().multiply(Integer.parseInt(args[1]));
                                t.setVelocity(v);
                                sender.sendMessage("§3You flung §b" + t.getName() + "§3 with a multiplier of §b" + Integer.parseInt(args[1]) + "§3!");
                            } else sender.sendMessage("§cFling multiplier cannot be bigger than four.");
                        } else InvalidCommand.FLING.sendMessage(sender);
                    } else InvalidCommand.FLING.sendMessage(sender);
                } else InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else InvalidCommand.FLING.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) return null;
        if (args.length == 2) return new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        return new ArrayList<>();
    }
}