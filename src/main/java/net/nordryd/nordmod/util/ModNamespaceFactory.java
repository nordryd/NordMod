package net.nordryd.nordmod.util;

import net.nordryd.nordmod.NordMod;

public abstract class ModNamespaceFactory
{
    public static String getModNamespace() {
        return NordMod.MOD_ID + ":";
    }

    public static String getBlockPath() {
        return getBlockPath("");
    }

    public static String getItemPath() {
        return getItemPath("");
    }

    public static String getBlockPath(final String blockName) {
        return "block/" + blockName;
    }

    public static String getItemPath(final String itemName) {
        return "item/" + itemName;
    }

    public static String getModNamespaceBlockPath() {
        return getModNamespace() + getBlockPath();
    }

    public static String getModNamespaceItemPath() {
        return getModNamespace() + getItemPath();
    }
}
