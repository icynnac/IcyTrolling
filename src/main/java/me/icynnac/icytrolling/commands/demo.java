package me.icynnac.icytrolling.commands;

import net.minecraft.server.v1_16_R3.PacketPlayOutGameStateChange;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class demo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("icytroll.demo")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    final PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.f,0.0F);
                    ((CraftPlayer) t).getHandle().playerConnection.sendPacket(packet);
                    sender.sendMessage(ChatColor.AQUA + t.getName() + ChatColor.DARK_AQUA + " just got demo'd!");
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist, did you make a typo?");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /demo (target's username)");
            }
        }
        return false;
    }
}
