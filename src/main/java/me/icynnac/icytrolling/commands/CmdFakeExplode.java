package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.utils.InvalidCommand;
import me.icynnac.icytrolling.utils.ServerVersion;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;

public class CmdFakeExplode implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (ServerVersion.get.roundedFromServer().getId() < 15) {
            InvalidCommand.NEWER_VERSION.sendMessage(sender);
            return true;
        }
        if (sender.hasPermission("icytroll.fakeexplode")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    t.spawnParticle(Particle.EXPLOSION_HUGE, t.getLocation(), 1);
                    t.playSound(t.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1, 1);
                } else return InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else return InvalidCommand.FAKEEXPLODE.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
