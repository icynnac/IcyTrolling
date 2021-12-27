package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.Main;
import me.icynnac.icytrolling.utils.InvalidCommand;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CmdLag implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.lag")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                        if (StringUtils.isNumeric(args[1])) {
                            int num = Integer.parseInt(args[1]);
                            if (0 < num && num < 61) {
                                int oneSec = scheduler.scheduleSyncRepeatingTask(Main.plugin, () -> t.teleport(t.getLocation()), 0, 3);
                                sender.sendMessage("§b" + t.getName() + "§3 is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.plugin, () -> scheduler.cancelTask(oneSec), 20 * num);
                            } else sender.sendMessage("§cLag time cannot be less than 1 or bigger than 60.");
                        } else InvalidCommand.LAG.sendMessage(sender);
                    } else InvalidCommand.LAG.sendMessage(sender);
                } else InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else InvalidCommand.LAG.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) return null;
        if (args.length == 2) return new ArrayList<>(Collections.singletonList("<Length in Seconds>"));
        return new ArrayList<>();
    }
}