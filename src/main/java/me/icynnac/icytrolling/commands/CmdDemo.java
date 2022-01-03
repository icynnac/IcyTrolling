package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.utils.InvalidCommand;
import me.icynnac.icytrolling.utils.Packets;
import me.icynnac.icytrolling.utils.ServerVersion;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CmdDemo implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (ServerVersion.get.roundedFromServer().getId() > 16) {
            InvalidCommand.OLDER_VERSION.sendMessage(sender);
            return true;
        }
        if (sender.hasPermission("icytroll.demo")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    new Packets().sendDemoPacket(t);
                    sender.sendMessage("§b" + t.getName() + "§3 just got demo'd!");
                } else return InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else return InvalidCommand.DEMO.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) return null;
        return new ArrayList<>();
    }
}