package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.utils.InvalidCommand;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdLevitate implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.levitate")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        if (StringUtils.isNumeric(args[1])) {
                            int num = Integer.parseInt(args[1]);
                            if (0 < num && num < 11) {
                                if (!t.hasPotionEffect(PotionEffectType.LEVITATION)) {
                                    t.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 99999999, num - 1));
                                    t.sendMessage("§3Whoops, you're going to the sun!");
                                    sender.sendMessage("§3Sent " + "§b" + t.getName() + "§3 to the sun.");
                                } else sender.sendMessage("§b" + t.getName() + "§3 already has levitation.");
                            } else sender.sendMessage("§cLevitation multiplier cannot be less than 1 or bigger than 10.");
                        } else if (args[1].equalsIgnoreCase("off")) {
                            if (t.hasPotionEffect(PotionEffectType.LEVITATION)) {
                                t.removePotionEffect(PotionEffectType.LEVITATION);
                                t.sendMessage("§3Whoops, you're falling.");
                                sender.sendMessage("§b" + t.getName() + "§3 is now coming back down...");
                            } else sender.sendMessage("§b" + t.getName() + "§3 doesn't have levitation.");
                        } else return InvalidCommand.LEVITATE.sendMessage(sender);
                    } else return InvalidCommand.LEVITATE.sendMessage(sender);
                } else return InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else return InvalidCommand.LEVITATE.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) return null;
        if (args.length == 2) return new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "off"));
        return new ArrayList<>();
    }
}