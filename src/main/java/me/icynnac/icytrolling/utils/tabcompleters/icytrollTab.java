package me.icynnac.icytrolling.utils.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class icytrollTab implements TabCompleter {
    List<String> arg = new ArrayList<>();
    List<String> arg2 = new ArrayList<>();
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        List<String> results = new ArrayList<>();
        if (arg.isEmpty()) {
            arg.add("config"); arg.add("demo"); arg.add("drop");
            arg.add("explode"); arg.add("burn"); arg.add("fling");
            arg.add("info"); arg.add("lag"); arg.add("levitate");
            arg.add("pumpkin");
        }
        if (arg2.isEmpty()) {
            arg2.add("reset"); arg2.add("reload");
        }
        if (args.length == 1) {
            results.clear();
            for (String a : arg) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    results.add(a);
            }
            return results;
        } else if (args.length == 2) {
            results.clear();
            for (String a : arg2) {
                if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                    results.add(a);
            }
            return results;
        }
        return null;
    }
}
