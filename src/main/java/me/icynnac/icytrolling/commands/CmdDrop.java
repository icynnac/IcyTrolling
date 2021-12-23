package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.utils.InvalidCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdDrop implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.drop")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (args.length > 1) {
                        if (args[1].equalsIgnoreCase("offhand") || args[1].equalsIgnoreCase("main")
                                || args[1].equalsIgnoreCase("both")) dropItem(sender, t, args[1].toLowerCase());
                        else return InvalidCommand.DROP.sendMessage(sender);
                    } else return InvalidCommand.DROP.sendMessage(sender);
                } else return InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else return InvalidCommand.DROP.sendMessage(sender);
        } return true;
    }

    public void dropItem(CommandSender sender, Player t, String slot) {
        if (slot.equalsIgnoreCase("both")) {
            dropItem(sender, t, "offhand");
            dropItem(sender, t, "main");
            return;
        } ItemStack handItem = t.getInventory().getItemInMainHand();
        if (slot.equalsIgnoreCase("offhand")) handItem = t.getInventory().getItemInOffHand();
        if (handItem.getType().isTransparent()) {
            if (slot.equalsIgnoreCase("offhand")) sender.sendMessage("§cTarget isn't holding any item in their offhand.");
            if (slot.equalsIgnoreCase("main")) sender.sendMessage("§cTarget isn't holding any item in their main hand.");
        } else {
            World w = t.getWorld();
            Item drop = w.dropItem(t.getLocation(), handItem);
            drop.setPickupDelay(40);
            drop.setVelocity(t.getLocation().getDirection());
            if (slot.equalsIgnoreCase("main")) {
                t.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                sender.sendMessage("§3Dropped the item in §b" + t.getName() + "§3's main hand.");
            }
            if (slot.equalsIgnoreCase("offhand")) {
                t.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                sender.sendMessage("§3Dropped the item in §b" + t.getName() + "§3's offhand.");
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) return null;
        if (args.length == 2) return new ArrayList<>(Arrays.asList("offhand", "main", "both"));
        return new ArrayList<>();
    }
}