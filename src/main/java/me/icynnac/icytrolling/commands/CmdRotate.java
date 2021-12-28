package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.utils.InvalidCommand;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdRotate implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.rotate")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        if (StringUtils.isNumeric(args[1])) {
                            int yaw = Integer.parseInt(args[1]);
                            if (0 < yaw && yaw < 361) {
                                Location loc = t.getLocation();
                                loc.setYaw(loc.getYaw() + yaw);
                                t.teleport(loc);
                                t.sendMessage("§b" + t.getName() + "§3 has been spun §b" + yaw + "§3 degrees!");
                            } else sender.sendMessage("§cSpin number cannot be less than 1 or bigger than 360.");
                        } else return InvalidCommand.SPIN.sendMessage(sender);
                    } else return InvalidCommand.SPIN.sendMessage(sender);
                } else return InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else return InvalidCommand.SPIN.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) return null;
        if (args.length == 2) return new ArrayList<>(Arrays.asList("90", "180", "270", "360"));
        return new ArrayList<>();
    }
}
