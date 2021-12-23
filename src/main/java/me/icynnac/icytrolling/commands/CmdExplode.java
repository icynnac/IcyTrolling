package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.utils.InvalidCommand;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CmdExplode implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.explode")) {
            if (args.length > 0) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (args.length > 2) {
                        int str = 0;
                        if (StringUtils.isNumeric(args[1])) str = Integer.parseInt(args[1]);
                        if (0 < str && str < 16) {
                            World w = target.getWorld();
                            w.createExplosion(target.getLocation(), str, Boolean.parseBoolean(args[2].toLowerCase()));
                            sender.sendMessage("§b" + target.getName() + " §3has been blown up!");
                            return true;
                        } return InvalidCommand.EXPLODE.sendMessage(sender);
                    } return InvalidCommand.EXPLODE.sendMessage(sender);
                } else return InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else return InvalidCommand.EXPLODE.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 1) return null;
        if (args.length == 2) {
            for (int i = 0; i < 15; i++) list.add(Integer.toString(i));
            return list;
        } if (args.length == 3) {
            list.add("true");
            list.add("false");
            return list;
        } return list;
    }
}
