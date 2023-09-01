package net.nordryd.nordmod.util;

import net.nordryd.nordmod.NordMod;

public abstract class ModNamespaceFactory
{
    public static String getModNamespace() {
        return NordMod.MOD_ID + ":";
    }

    public static String getModBlockNamespace() {
        return getModNamespace() + "block/";
    }
}
