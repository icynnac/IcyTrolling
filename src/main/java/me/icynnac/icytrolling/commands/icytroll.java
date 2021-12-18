package me.icynnac.icytrolling.commands;

import me.icynnac.icytrolling.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Objects;

public class icytroll implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("icytroll.icytroll")) {
            if (args.length > 0) {
                PluginDescriptionFile pluginyml = Main.instance.getDescription();
                switch(args[0].toLowerCase()) {
                    default:
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        TextComponent demo = new TextComponent(ChatColor.AQUA + "" + ChatColor.BOLD + "/demo " + ChatColor.DARK_AQUA + "- Classic Demo Screen troll.");
                        demo.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/icytroll demo"));
                        sender.spigot().sendMessage(demo);
                        break;
                    case "burn":
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        TextComponent burnuse = new TextComponent(ChatColor.GOLD + "Usage: /burn (target player's name) (burn time in ticks)");
                        burnuse.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/burn "));
                        burnuse.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to use /burn").create()));
                        sender.sendMessage(ChatColor.AQUA + "Set someone on fire, for however long you please!");
                        sender.sendMessage(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "Or at least however long the integer limit allows...");
                        sender.sendMessage(ChatColor.GREEN + "Tip: Every second is 20 ticks, use that to decide the length.");
                        sender.spigot().sendMessage(burnuse);
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
                        break;
                    case "demo":
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        TextComponent demouse = new TextComponent(ChatColor.GOLD + "Usage: /demo (target player's name)");
                        demouse.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/demo "));
                        demouse.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to use /demo").create()));
                        sender.sendMessage(ChatColor.AQUA + "Send someone a demo screen.");
                        sender.sendMessage(ChatColor.AQUA + "They should have bought the game.");
                        sender.spigot().sendMessage(demouse);
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
                        break;
                    case "drop":
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        TextComponent dropuse = new TextComponent(ChatColor.GOLD + "Usage: /drop (target player's name) [main/offhand/both]");
                        dropuse.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/drop "));
                        dropuse.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to use /drop").create()));
                        sender.sendMessage(ChatColor.AQUA + "Make someone drop an item in their hands.");
                        sender.sendMessage(ChatColor.AQUA + "How clumsy!");
                        sender.spigot().sendMessage(dropuse);
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
                        break;
                    case "explode":
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        TextComponent expuse = new TextComponent(ChatColor.GOLD + "Usage: /explode (target player's name) (explosion power)");
                        expuse.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/explode "));
                        expuse.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to use /explode").create()));
                        sender.sendMessage(ChatColor.AQUA + "Make someone explode.");
                        sender.sendMessage(ChatColor.AQUA + "I mean, what other information do you need?");
                        sender.sendMessage(ChatColor.GREEN + "Tip: The maximum explosion power is 15, anything above crashed Icynnac's test server.");
                        sender.sendMessage(ChatColor.RED + "Warning: This command damages terrain, do not use this near any builds.");
                        sender.spigot().sendMessage(expuse);
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
                        break;
                    case "fling":
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        TextComponent flinguse = new TextComponent(ChatColor.GOLD + "Usage: /fling (target player's name) (fling power)");
                        flinguse.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/fling "));
                        flinguse.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to use /fling").create()));
                        sender.sendMessage(ChatColor.AQUA + "Send someone to the sun!");
                        sender.sendMessage(ChatColor.AQUA + "(May send some people to the moon, depends on time of day.)");
                        sender.sendMessage(ChatColor.GREEN + "Tip: The maximum fling power is 4, anything above simply didn't work.");
                        sender.spigot().sendMessage(flinguse);
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
                        break;
                    case "info":
                        TextComponent github = new TextComponent(ChatColor.AQUA + "https://github.com/icynnac/IcyTrolling");
                        github.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/icynnac/IcyTrolling"));
                        github.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to open the GitHub site").create()));
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        sender.sendMessage(ChatColor.DARK_AQUA + "Made by " + ChatColor.AQUA + "Icynnac");
                        sender.sendMessage(ChatColor.DARK_AQUA + "Version: " + ChatColor.AQUA + pluginyml.getVersion());
                        sender.sendMessage(ChatColor.DARK_AQUA + "GitHub:");
                        sender.spigot().sendMessage(github);
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
                        break;
                    case "lag":
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        TextComponent laguse = new TextComponent(ChatColor.GOLD + "Usage: /lag (target player's name) (lag time)");
                        laguse.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lag "));
                        laguse.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to use /lag").create()));
                        sender.sendMessage(ChatColor.AQUA + "Send someone to the sun!");
                        sender.sendMessage(ChatColor.AQUA + "(May send some people to the moon, depends on time of day.)");
                        sender.sendMessage(ChatColor.GREEN + "Tip: The maximum lag time is 10, but I could change that later.");
                        sender.spigot().sendMessage(laguse);
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
                        break;
                    case "levitate":
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        TextComponent levuse = new TextComponent(ChatColor.GOLD + "Usage: /levitate (target player's name) (levitation power)");
                        levuse.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/fling "));
                        levuse.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to use /fling").create()));
                        sender.sendMessage(ChatColor.AQUA + "Send someone to the sun!");
                        sender.sendMessage(ChatColor.AQUA + "(OK, same concept as /fling, but this one lasts a LOOOONG while.");
                        sender.sendMessage(ChatColor.GREEN + "Tip: The maximum levitate power at the moment is 5, will change that later.");
                        sender.spigot().sendMessage(levuse);
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
                        break;
                    case "pumpkin":
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD  + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                        TextComponent pumpuse = new TextComponent(ChatColor.GOLD + "Usage: /pumpkin (target player's name) [on/off]");
                        pumpuse.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/pumpkin "));
                        pumpuse.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to use /pumpkin").create()));
                        sender.sendMessage(ChatColor.AQUA + "Put a really inconvenient hat on someone's head!");
                        sender.sendMessage(ChatColor.AQUA + "(It's very inconvenient because it has curse of binding.)");
                        sender.spigot().sendMessage(pumpuse);
                        sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
                        break;
                    case "config":
                        if (args.length > 1) {
                            switch(args[1].toLowerCase()) {
                                case "reset":
                                    File config = new File(Main.instance.getDataFolder(), "config.yml");
                                    //noinspection ResultOfMethodCallIgnored
                                    config.delete();
                                    Main.instance.saveDefaultConfig();
                                    Bukkit.getPluginManager().disablePlugin(Main.instance);
                                    Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("IcyTrolling")).reloadConfig();
                                    Bukkit.getPluginManager().enablePlugin(Main.instance);
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + "&b config.yml has been reset to default."));
                                    break;
                                case "reload":
                                    Bukkit.getPluginManager().disablePlugin(Main.instance);
                                    Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("IcyTrolling")).reloadConfig();
                                    Bukkit.getPluginManager().enablePlugin(Main.instance);
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + "&b config.yml has been reloaded."));
                                    break;
                            }
                        }
                }
            } else {
                sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|" + ChatColor.AQUA + "" + ChatColor.BOLD + "IcyTrolling" + ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "|--------------");
                TextComponent demo = new TextComponent(ChatColor.AQUA + "" + ChatColor.BOLD + "/demo " + ChatColor.DARK_AQUA + "- Classic Demo Screen troll.");
                demo.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/icytroll demo"));
                demo.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see /demo info.").create()));
                TextComponent burn = new TextComponent(ChatColor.AQUA + "" + ChatColor.BOLD + "/burn " + ChatColor.DARK_AQUA + "- Light someone on fire!");
                burn.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/icytroll burn"));
                burn.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see /burn info.").create()));
                TextComponent drop = new TextComponent(ChatColor.AQUA + "" + ChatColor.BOLD + "/drop " + ChatColor.DARK_AQUA + "- Make someone drop what's in their hands.");
                drop.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/icytroll drop"));
                drop.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see /drop info.").create()));
                TextComponent boom = new TextComponent(ChatColor.AQUA + "" + ChatColor.BOLD + "/explode " + ChatColor.RED + "- Kaboom.");
                boom.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/icytroll explode"));
                boom.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see /explode info.").create()));
                TextComponent fling = new TextComponent(ChatColor.AQUA + "" + ChatColor.BOLD + "/fling " + ChatColor.DARK_AQUA + "- Throw someone in the air.");
                fling.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/icytroll fling"));
                fling.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see /fling info.").create()));
                TextComponent lag = new TextComponent(ChatColor.AQUA + "" + ChatColor.BOLD + "/lag " + ChatColor.DARK_AQUA + "- Give someone my internet.");
                lag.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/icytroll lag"));
                lag.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see /lag info.").create()));
                TextComponent levitate = new TextComponent(ChatColor.AQUA + "" + ChatColor.BOLD + "/levitate " + ChatColor.DARK_AQUA + "- Send someone slowly to the sun.");
                levitate.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/icytroll levitate"));
                levitate.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see /levitate info.").create()));
                TextComponent pumpkin = new TextComponent(ChatColor.AQUA + "" + ChatColor.BOLD + "/pumpkin " + ChatColor.DARK_AQUA + "- Give someone a pumpkin hat!");
                pumpkin.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/icytroll pumpkin"));
                pumpkin.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see /pumpkin info.").create()));
                sender.spigot().sendMessage(burn);
                sender.spigot().sendMessage(demo);
                sender.spigot().sendMessage(drop);
                sender.spigot().sendMessage(boom);
                sender.spigot().sendMessage(fling);
                sender.spigot().sendMessage(lag);
                sender.spigot().sendMessage(levitate);
                sender.spigot().sendMessage(pumpkin);
                sender.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + "--------------|-----------|--------------");
            }
        }
        return false;
    }
}
