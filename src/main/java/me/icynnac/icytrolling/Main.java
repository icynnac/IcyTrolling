package me.icynnac.icytrolling;

import me.icynnac.icytrolling.commands.*;
import me.icynnac.icytrolling.utils.tabcompleters.dropTab;
import me.icynnac.icytrolling.utils.tabcompleters.pumpkinTab;
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
        Objects.requireNonNull(getCommand("pumpkin")).setExecutor(new pumpkin());
        Objects.requireNonNull(getCommand("pumpkin")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("pumpkin")).setTabCompleter(new pumpkinTab());
        Objects.requireNonNull(getCommand("fling")).setExecutor(new fling());
        Objects.requireNonNull(getCommand("fling")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("levitate")).setExecutor(new fly());
        Objects.requireNonNull(getCommand("levitate")).setPermissionMessage("no.");
    }
}
