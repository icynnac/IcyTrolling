package me.icynnac.icytrolling.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class pumpkin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.pumpkin")) {
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    ItemStack pumpkin = new ItemStack(Material.CARVED_PUMPKIN);
                    ItemMeta pmeta = pumpkin.getItemMeta();
                    assert pmeta != null;
                    pmeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Really Inconvenient Hat!");
                    pmeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
                    pumpkin.setItemMeta(pmeta);
                    if (args.length > 1) {
                        if (args[1].equalsIgnoreCase("on")) {
                            if (Objects.equals(Objects.requireNonNull(t.getEquipment()).getHelmet(), pumpkin)) {
                                sender.sendMessage(ChatColor.RED + "Target already has a really inconvenient hat.");
                            } else {
                                sender.sendMessage(ChatColor.GOLD + t.getName() + " now has a really inconvenient hat!");
                                t.sendMessage(ChatColor.RED + "You now have a really inconvenient hat!");
                                Objects.requireNonNull(t.getEquipment()).setHelmet(pumpkin);
                            }
                        } else if (args[1].equalsIgnoreCase("off")) {
                            if (!Objects.equals(Objects.requireNonNull(t.getEquipment()).getHelmet(), pumpkin)) {
                                sender.sendMessage(ChatColor.RED + "Target does not have a really inconvenient hat.");
                            } else {
                                Objects.requireNonNull(t.getEquipment()).setHelmet(new ItemStack(Material.AIR));
                            }
                            Objects.requireNonNull(t.getEquipment()).setHelmet(new ItemStack(Material.AIR));
                        } else {
                            sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /pumpkin (target's username) [on/off]");
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /pumpkin (target's username) [on/off]");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist, did you make a typo?");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "That command doesn't look right, try: /pumpkin (target's username) [on/off]");
            }
        }
        return false;
    }
}
