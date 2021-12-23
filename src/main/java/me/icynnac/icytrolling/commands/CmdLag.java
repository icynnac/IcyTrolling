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
import java.util.Arrays;
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
                            if (0 < num && num < 21) {
                                int oneSec = scheduler.scheduleSyncRepeatingTask(Main.plugin, () -> t.teleport(t.getLocation()), 0, 3);
                                sender.sendMessage("§b" + t.getName() + "§3 is now lagging!");
                                scheduler.scheduleSyncDelayedTask(Main.plugin, () -> scheduler.cancelTask(oneSec), 20 * num);
                            } else sender.sendMessage("§cInvalid time, maximum lag time is 20s.");
                        } else InvalidCommand.LAG.sendMessage(sender);
                    } else InvalidCommand.LAG.sendMessage(sender);
                } else InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else InvalidCommand.LAG.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) return null;
        if (args.length == 2) return new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"));
        return new ArrayList<>();
    }
}