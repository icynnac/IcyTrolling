package me.icynnac.icytrolling.utils;

import me.icynnac.icytrolling.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import static me.icynnac.icytrolling.Main.plugin;

public enum InvalidCommand {
    NO_PLAYER(0),
    DEMO(1),
    DROP(2),
    EXPLODE(3),
    FIRE(4),
    LEVITATE(5),
    FLING(6),
    LAG(7),
    PUMPKIN(8),
    SCAM(9),
    FAKEEXPLODE(10),
    SPIN(11),
    ROTATE(12),
    CONFIG(13);

    public final int id;

    InvalidCommand(int id) { this.id = id; }

    public boolean sendMessage(CommandSender sender) {
        StringBuilder sb = new StringBuilder(Main.prefix + " ");
        String node = "";
        if (id > 0) node = ("messages.invalid-cmd-" + this.toString().toLowerCase());
        else if (id == 0) node = "messages.invalid-player";
        sb.append(plugin.getConfig().getString(node));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', sb.toString()));
        return true;
    }
}