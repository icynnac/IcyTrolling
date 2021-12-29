package me.icynnac.icytrolling.utils;

import org.bukkit.Bukkit;

public enum ServerVersion {
    get(null, null, -1),
    v1_8(true, true, 8),
    v1_9(true, true, 9),
    v1_10(true, true, 10),
    v1_11(true, true, 11),
    v1_12(true, true, 12),
    v1_13(false, true, 13),
    v1_14(false, true, 14),
    v1_15(false, true, 15),
    v1_16(false, false, 16),
    v1_17(false, false, 17),
    v1_18(false, false, 18);

    final Boolean isLegacy;
    final Boolean useOldPackets;
    final int id;

    ServerVersion(Boolean isLegacy, Boolean useOldPackets, int id) {
        this.isLegacy = isLegacy;
        this.useOldPackets = useOldPackets;
        this.id = id;
    }

    public boolean isLegacy() {
        return isLegacy;
    }

    public boolean useOldPackets() {
        return useOldPackets;
    }

    public int getId() {
        return id;
    }

    public String fromServer() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    }

    public ServerVersion roundedFromServer() {
        if (fromServer().startsWith("v1_18")) return v1_18;
        if (fromServer().startsWith("v1_17")) return v1_17;
        if (fromServer().startsWith("v1_16")) return v1_16;
        if (fromServer().startsWith("v1_15")) return v1_15;
        if (fromServer().startsWith("v1_14")) return v1_14;
        if (fromServer().startsWith("v1_13")) return v1_13;
        if (fromServer().startsWith("v1_12")) return v1_12;
        if (fromServer().startsWith("v1_11")) return v1_11;
        if (fromServer().startsWith("v1_10")) return v1_10;
        if (fromServer().startsWith("v1_9")) return v1_9;
        if (fromServer().startsWith("v1_8")) return v1_8;
        return null;
    }
}