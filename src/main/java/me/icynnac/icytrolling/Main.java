package me.icynnac.icytrolling;

import me.icynnac.icytrolling.commands.*;
import me.icynnac.icytrolling.utils.tabcompleters.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    public static Plugin instance;
    
    public static String prefix;
    public static String noplr;

    public static String badcmddemo;
    public static String badcmddrop;
    public static String badcmdfire;
    public static String badcmdboom;
    public static String badcmdfly;
    public static String badcmdfling;
    public static String badcmdlag;
    public static String badcmdpumpkin;

    @Override
    public void onEnable() {
        instance = this;
        prefix = this.getConfig().getString("messages.prefix");
        noplr = this.getConfig().getString("messages.invalid-player");

        badcmddemo = this.getConfig().getString("messages.invalid-cmd-demo");
        badcmddrop = this.getConfig().getString("messages.invalid-cmd-drop");
        badcmdboom = this.getConfig().getString("messages.invalid-cmd-explode");
        badcmdfire = this.getConfig().getString("messages.invalid-cmd-fire");
        badcmdfly = this.getConfig().getString("messages.invalid-cmd-levitate");
        badcmdfling = this.getConfig().getString("messages.invalid-cmd-fling");
        badcmdlag = this.getConfig().getString("messages.invalid-cmd-lag");
        badcmdpumpkin = this.getConfig().getString("messages.invalid-cmd-pumpkin");

        Objects.requireNonNull(getCommand("icytroll")).setExecutor(new icytroll());
        Objects.requireNonNull(getCommand("icytroll")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("icytroll")).setTabCompleter(new icytrollTab());
        Objects.requireNonNull(getCommand("explode")).setExecutor(new explode());
        Objects.requireNonNull(getCommand("explode")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("explode")).setTabCompleter(new explodeTab());
        Objects.requireNonNull(getCommand("burn")).setExecutor(new burn());
        Objects.requireNonNull(getCommand("burn")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("drop")).setExecutor(new drop());
        Objects.requireNonNull(getCommand("drop")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("drop")).setTabCompleter(new dropTab());
        Objects.requireNonNull(getCommand("pumpkin")).setExecutor(new pumpkin());
        Objects.requireNonNull(getCommand("pumpkin")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("pumpkin")).setTabCompleter(new pumpkinTab());
        Objects.requireNonNull(getCommand("fling")).setExecutor(new fling());
        Objects.requireNonNull(getCommand("fling")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("levitate")).setExecutor(new levitate());
        Objects.requireNonNull(getCommand("levitate")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("levitate")).setTabCompleter(new flyTab());
        Objects.requireNonNull(getCommand("lag")).setExecutor(new lag());
        Objects.requireNonNull(getCommand("lag")).setPermissionMessage("no.");
        Objects.requireNonNull(getCommand("lag")).setTabCompleter(new lagTab());
        Objects.requireNonNull(getCommand("demo")).setExecutor(new demo());
        Objects.requireNonNull(getCommand("demo")).setPermissionMessage("no.");

        saveDefaultConfig();

    }
}
