package me.icynnac.icytrolling.utils.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class explodeTab implements TabCompleter {
    List<String> arg = new ArrayList<>();
    List<String> arg2 = new ArrayList<>();
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        List<String> results = new ArrayList<>();
        if (arg.isEmpty()) {
            arg.add("1"); arg.add("2"); arg.add("3"); arg.add("4"); arg.add("5"); arg.add("6");
            arg.add("7"); arg.add("8"); arg.add("9"); arg.add("10"); arg.add("11"); arg.add("12");
            arg.add("13"); arg.add("14"); arg.add("15");
        }
        if (arg2.isEmpty()) {
            arg2.add("true"); arg2.add("false");
        }
        if (args.length == 2) {
            results.clear();
            for (String a : arg) {
                if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                    results.add(a);
            }
            return results;
        } else if (args.length == 3) {
            results.clear();
            for (String a : arg2) {
                if (a.toLowerCase().startsWith(args[2].toLowerCase()))
                    results.add(a);
            }
            return results;
        }
        return null;
    }
}
