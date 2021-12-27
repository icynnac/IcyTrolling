package me.icynnac.icytrolling.events;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static me.icynnac.icytrolling.Main.playerDecreasedHealth;

public class UIEvents implements Listener {
    @EventHandler
    public void onClickClack(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("§aFree Emeralds!")) {
            Player player = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.EMERALD) {
                Random random = new Random();
                int rand_int = random.nextInt(5);
                switch (rand_int) {
                    case 0:
                        player.closeInventory();
                        World w = player.getWorld();
                        w.createExplosion(player.getLocation(), 5, true);
                        player.sendMessage("§cGet scammed noob.");
                        break;
                    case 1:
                        player.closeInventory();
                        player.setHealth(0);
                        player.sendMessage("§cGet scammed noob.");
                        break;
                    case 2:
                        player.closeInventory();
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100000, 3));
                        player.sendMessage("§cGet scammed noob.");
                        break;
                    case 3:
                        player.closeInventory();
                        ItemStack epicdirt = new ItemStack(Material.DIRT);
                        ItemMeta ed = epicdirt.getItemMeta();
                        ed.setDisplayName("§aEmerald");
                        epicdirt.setItemMeta(ed);
                        player.getInventory().addItem(epicdirt);
                        player.sendMessage("§cGet scammed noob.");
                        break;
                    case 4:
                        player.closeInventory();
                        player.setMaxHealth(2);
                        playerDecreasedHealth.put(player.getUniqueId(), true);
                        player.sendMessage("§cGet scammed noob.");
                        break;
                }
            }
        }
    }
}