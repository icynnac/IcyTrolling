package me.icynnac.icytrolling.utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;

public class InteractiveMessage {
    public static void sendInteractiveMessage(CommandSender sender, String msg, String value, ClickEvent.Action clickAction, String hoverText) {
        TextComponent message = new TextComponent(msg);
        message.setClickEvent(new ClickEvent(clickAction, value));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverText).create()));
        sender.spigot().sendMessage(message);
    }
}
