package me.icynnac.icytrolling;

import me.icynnac.icytrolling.commands.*;
import me.icynnac.icytrolling.events.PlayerEvents;
import me.icynnac.icytrolling.events.UIEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {

    public static Main plugin;

    public static HashMap<UUID, ItemStack> playerPumpkinHeads = new HashMap<>();
    public static HashMap<UUID, Boolean> playerDecreasedHealth = new HashMap<>();

    public static String prefix;

    @Override
    public void onEnable() {
        plugin = this;
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.prefix"));

        Bukkit.getPluginManager().registerEvents(new UIEvents(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);

        getCommand("levitate").setPermissionMessage("no.");
        getCommand("icytroll").setPermissionMessage("no.");
        getCommand("explode").setPermissionMessage("no.");
        getCommand("pumpkin").setPermissionMessage("no.");
        getCommand("demo").setPermissionMessage("no.");
        getCommand("fling").setPermissionMessage("no.");
        getCommand("burn").setPermissionMessage("no.");
        getCommand("drop").setPermissionMessage("no.");
        getCommand("lag").setPermissionMessage("no.");
        getCommand("scam").setPermissionMessage("no.");
        getCommand("fakeexplode").setPermissionMessage("no.");
        getCommand("rotate").setPermissionMessage("no.");

        getCommand("levitate").setExecutor(new CmdLevitate());
        getCommand("icytroll").setExecutor(new CmdIcyTroll());
        getCommand("explode").setExecutor(new CmdExplode());
        getCommand("pumpkin").setExecutor(new CmdPumpkin());
        getCommand("demo").setExecutor(new CmdDemo());
        getCommand("fling").setExecutor(new CmdFling());
        getCommand("burn").setExecutor(new CmdBurn());
        getCommand("drop").setExecutor(new CmdDrop());
        getCommand("lag").setExecutor(new CmdLag());
        getCommand("scam").setExecutor(new CmdScam());
        getCommand("fakeexplode").setExecutor(new CmdFakeExplode());
        getCommand("rotate").setExecutor(new CmdRotate());

        saveDefaultConfig();

        //new UpdateChecker(this, 98539).getVersion(version -> {
        // if (!this.getDescription().getVersion().equalsIgnoreCase(version)) {
        //      Bukkit.getConsoleSender().sendMessage("§b§lIcy§3§lTrolling §8§l>> §eThere's a new version available! Head to the spigot page (/icytroll info) to get the latest version.");
        //  } else {
        //      Bukkit.getConsoleSender().sendMessage("§b§lIcy§3§lTrolling §8§l>> §aYou're on the latest version.");
        //  }
        //});
    }

    @Override
    public void onDisable() {
        for (UUID uuid : playerPumpkinHeads.keySet())
            Bukkit.getOfflinePlayer(uuid).getPlayer().getEquipment().setHelmet(playerPumpkinHeads.get(uuid));
        for (UUID uuid : playerDecreasedHealth.keySet())
            Bukkit.getOfflinePlayer(uuid).getPlayer().setMaxHealth(20);
    }
}
