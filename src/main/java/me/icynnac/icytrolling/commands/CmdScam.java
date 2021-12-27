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
                    for (int i = 0; i < 27; i++) inv.setItem(i, background);
                    inv.setItem(13,emerald);

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
