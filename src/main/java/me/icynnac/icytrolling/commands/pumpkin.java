package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.Main;
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
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class pumpkin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
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
                        switch (args[1].toLowerCase()) {
                            case "on":
                                if (Objects.equals(Objects.requireNonNull(t.getEquipment()).getHelmet(), pumpkin)) {
                                    sender.sendMessage(ChatColor.RED + "Target already has a really inconvenient hat.");
                                } else {
                                    sender.sendMessage(ChatColor.GOLD + t.getName() + " now has a really inconvenient hat!");
                                    t.sendMessage(ChatColor.RED + "You now have a really inconvenient hat!");
                                    Objects.requireNonNull(t.getEquipment()).setHelmet(pumpkin);
                                }
                                break;
                            case "off":
                                if (!Objects.equals(Objects.requireNonNull(t.getEquipment()).getHelmet(), pumpkin)) {
                                    sender.sendMessage(ChatColor.RED + "Target does not have a really inconvenient hat.");
                                } else {
                                    Objects.requireNonNull(t.getEquipment()).setHelmet(new ItemStack(Material.AIR));
                                }
                                break;
                            default:
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmdpumpkin));
                                break;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmdpumpkin));
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.prefix + " " + Main.noplr));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + " " + Main.badcmdpumpkin));
            }
        }
        return false;
    }
}
