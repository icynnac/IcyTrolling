package me.icynnac.icytrolling.utils;

import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class Packets {
    private Class<?> getNMSClass(String className) {
        try {
            return Class.forName("net.minecraft.server." + ServerVersion.get.fromServer() + "." + className);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } return null;
    }

    public void sendDemoPacket(Player player) {
        try {
            Constructor<?> packetConstructor;
            Object packet;
            if (ServerVersion.get.roundedFromServer().useOldPackets()) {
                packetConstructor = getNMSClass("PacketPlayOutGameStateChange").getConstructor(int.class, float.class);
                packet = packetConstructor.newInstance(5, 0);
            } else {
                packetConstructor = getNMSClass("PacketPlayOutGameStateChange").getConstructor(getNMSClass("PacketPlayOutGameStateChange$a"), float.class);
                packet = packetConstructor.newInstance(getNMSClass("PacketPlayOutGameStateChange$a").getConstructor(new Class[] { int.class })
                        .newInstance(5), 0);
            } Object handle = player.getClass().getMethod("getHandle").invoke(player);
            Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
            playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}