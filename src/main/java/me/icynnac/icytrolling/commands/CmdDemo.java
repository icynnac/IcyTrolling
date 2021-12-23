package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.utils.InvalidCommand;
import net.minecraft.server.v1_12_R1.PacketPlayOutGameStateChange;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CmdDemo implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.demo")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    final PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(5, 0.0F);
                    ((CraftPlayer) t).getHandle().playerConnection.sendPacket(packet);
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