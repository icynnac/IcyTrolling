package me.icynnac.icytrolling.events;

import me.icynnac.icytrolling.Main;
import me.icynnac.icytrolling.utils.ServerVersion;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        if (Main.playerPumpkinHeads.containsKey(e.getPlayer().getUniqueId())) {
            e.getPlayer().getEquipment().setHelmet(Main.playerPumpkinHeads.get(e.getPlayer().getUniqueId()));
            Main.playerPumpkinHeads.remove(e.getPlayer().getUniqueId());
        }
        if (Main.playerDecreasedHealth.containsKey(e.getPlayer().getUniqueId())) {
            e.getPlayer().setMaxHealth(20);
            Main.playerDecreasedHealth.remove(e.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        if (Main.playerPumpkinHeads.containsKey(e.getPlayer().getUniqueId())) {
            ItemStack pumpkin = new ItemStack(Material.PUMPKIN);
            ItemMeta pMeta = pumpkin.getItemMeta();
            pMeta.setDisplayName("§c§lReally Inconvenient Hat!");
            pMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
            pumpkin.setItemMeta(pMeta);
            e.getPlayer().getEquipment().setHelmet(pumpkin);
        }
        if (Main.playerDecreasedHealth.containsKey(e.getPlayer().getUniqueId())) {
            e.getPlayer().setMaxHealth(20);
            Main.playerDecreasedHealth.remove(e.getPlayer().getUniqueId());
        }
    }
}