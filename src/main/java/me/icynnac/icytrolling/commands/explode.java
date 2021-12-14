package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;

public class explode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("icytroll.explode")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    t.sendMessage(ChatColor.RED + "you have the bomb.");
                    sender.sendMessage(ChatColor.RED + "You gave " + t.getName() + " the bomb!");
                    t.playSound(t.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);
                    BukkitScheduler scheduler = Bukkit.getScheduler();
                    scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
                        t.sendMessage(ChatColor.GREEN + "5");
                        t.playNote(t.getLocation(), Instrument.BELL, Note.natural(1, Note.Tone.C));
                    },20*5);
                    scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
                        t.sendMessage(ChatColor.DARK_GREEN + "4");
                        t.playNote(t.getLocation(), Instrument.BELL, Note.natural(1, Note.Tone.D));
                    },20*6);
                    scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
                        t.sendMessage(ChatColor.YELLOW + "3");
                        t.playNote(t.getLocation(), Instrument.BELL, Note.natural(1, Note.Tone.E));
                    },20*7);
                    scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
                        t.sendMessage(ChatColor.GOLD + "2");
                        t.playNote(t.getLocation(), Instrument.BELL, Note.natural(1, Note.Tone.F));
                    },20*8);
                    scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
                        t.sendMessage(ChatColor.RED + "1");
                        t.playNote(t.getLocation(), Instrument.BELL, Note.natural(1, Note.Tone.G));
                    },20*9);
                    scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
                        World w = t.getWorld();
                        sender.sendMessage(ChatColor.DARK_RED + "boooom");
                        t.sendMessage(ChatColor.DARK_RED + "boooom");
                        w.createExplosion(t.getLocation(), Main.instance.getConfig().getInt("commands.explode-power"), Main.instance.getConfig().getBoolean("commands.explode-fire"));
                    },20*10);
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist, did you make a typo?");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /explode (target's username)");
            }
        }
        return false;
    }
}
