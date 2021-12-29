package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.Main;
import me.icynnac.icytrolling.utils.InvalidCommand;
import me.icynnac.icytrolling.utils.ServerVersion;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdPumpkin implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("icytroll.pumpkin")) {
            if (ServerVersion.get.roundedFromServer().getId() < 11) {
                InvalidCommand.OUTDATED_VERSION.sendMessage(sender);
                return true;
            }
            if (args.length > 0) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    ItemStack pumpkin = new ItemStack(Material.PUMPKIN);
                    ItemMeta pMeta = pumpkin.getItemMeta();
                    pMeta.setDisplayName("§c§lReally Inconvenient Hat!");
                    pMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
                    pumpkin.setItemMeta(pMeta);
                    if (args.length > 1) {
                        if (args[1].equalsIgnoreCase("on")) {
                            if ((t.getEquipment().getHelmet() != null) && t.getEquipment().getHelmet().equals(pumpkin))
                                sender.sendMessage("§cTarget already has a really inconvenient hat.");
                            else {
                                Main.playerPumpkinHeads.put(t.getUniqueId(), t.getEquipment().getHelmet());
                                sender.sendMessage("§6" + t.getName() + " now has a really inconvenient hat!");
                                t.sendMessage("§cYou now have a really inconvenient hat!");
                                t.getEquipment().setHelmet(pumpkin);
                            }
                        } else if (args[1].equalsIgnoreCase("off")) {
                            if ((t.getEquipment().getHelmet() != null) && !t.getEquipment().getHelmet().equals(pumpkin)) sender.sendMessage("§cTarget does not have a really inconvenient hat.");
                            else {
                                t.getEquipment().setHelmet(Main.playerPumpkinHeads.get(t.getUniqueId()));
                                Main.playerPumpkinHeads.remove(t.getUniqueId());
                                sender.sendMessage("§6" + t.getName() + " no longer has a really inconvenient hat!");
                            }
                        } else InvalidCommand.PUMPKIN.sendMessage(sender);
                    } else InvalidCommand.PUMPKIN.sendMessage(sender);
                } else InvalidCommand.NO_PLAYER.sendMessage(sender);
            } else InvalidCommand.PUMPKIN.sendMessage(sender);
        } return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) return null;
        if (args.length == 2) return new ArrayList<>(Arrays.asList("on", "off"));
        return new ArrayList<>();
    }
}
