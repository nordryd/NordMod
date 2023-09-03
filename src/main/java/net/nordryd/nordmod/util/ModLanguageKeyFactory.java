package net.nordryd.nordmod.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class ModLanguageKeyFactory
{
    public static String getKey(final Item item) {
        return String.format("item.%s.", ForgeRegistries.ITEMS.getKey(item)
                .toLanguageKey());
    }

    public static String getKey(final Block block) {
        return String.format("block.%s.", ForgeRegistries.BLOCKS.getKey(block)
                .toLanguageKey());
    }
}
