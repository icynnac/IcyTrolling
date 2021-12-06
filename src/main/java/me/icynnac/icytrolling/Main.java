package me.icynnac.icytrolling;

import me.icynnac.icytrolling.commands.drop;
import me.icynnac.icytrolling.commands.explode;
import me.icynnac.icytrolling.commands.fire;
import me.icynnac.icytrolling.utils.tabcompleters.dropTab;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;

        Objects.requireNonNull(getCommand("explode")).setExecutor(new explode());
        Objects.requireNonNull(getCommand("explode")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("burn")).setExecutor(new fire());
        Objects.requireNonNull(getCommand("burn")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("drop")).setExecutor(new drop());
        Objects.requireNonNull(getCommand("drop")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("drop")).setTabCompleter(new dropTab());
    }
}
