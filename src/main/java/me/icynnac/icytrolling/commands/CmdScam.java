package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.utils.InvalidCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CmdScam implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.scam")) {
            if (args.length > 0) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    Inventory inv = Bukkit.createInventory(target, 27, "§aFree Emeralds!");
                    ItemStack background = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
                    ItemStack emerald = new ItemStack(Material.EMERALD);
                    ItemMeta bg = background.getItemMeta();
                    ItemMeta em = emerald.getItemMeta();
                    bg.setDisplayName(" ");
                    em.setDisplayName("§aClick here to get your free emeralds!");
                    background.setItemMeta(bg);
                    emerald.setItemMeta(em);
                    inv.setItem(0,background);
                    inv.setItem(1,background);
                    inv.setItem(2,background);
                    inv.setItem(3,background);
                    inv.setItem(4,background);
                    inv.setItem(5,background);
                    inv.setItem(6,background);
                    inv.setItem(7,background);
                    inv.setItem(8,background);
                    inv.setItem(9,background);
                    inv.setItem(10,background);
                    inv.setItem(11,background);
                    inv.setItem(12,background);
                    inv.setItem(13,emerald);
                    inv.setItem(14,background);
                    inv.setItem(15,background);
                    inv.setItem(16,background);
                    inv.setItem(17,background);
                    inv.setItem(18,background);
                    inv.setItem(19,background);
                    inv.setItem(20,background);
                    inv.setItem(21,background);
                    inv.setItem(22,background);
                    inv.setItem(23,background);
                    inv.setItem(24,background);
                    inv.setItem(25,background);
                    inv.setItem(26,background);

                    target.openInventory(inv);
                } else return InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else return InvalidCommand.SCAM.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
