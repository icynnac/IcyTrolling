package me.icynnac.icytrolling.utils.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class pumpkinTab implements TabCompleter {
    List<String> arg = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (arg.isEmpty()) {
            arg.add("on"); arg.add("off");
        }
        List<String> results = new ArrayList<>();
        if (args.length > 1) {
            for (String a : arg) {
                if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                    results.add(a);
            }
            return results;
        }
        return null;
    }
}
