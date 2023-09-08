package net.nordryd.nordmod.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class ModLanguageKeyFactory
{
    public static String getKey(final Item item, final String subKey) {
        return String.format("item.%s.%s", ForgeRegistries.ITEMS.getKey(item)
                .toLanguageKey(), subKey);
    }

    public static String getKey(final Block block, final String subKey) {
        return String.format("block.%s.%s", ForgeRegistries.BLOCKS.getKey(block)
                .toLanguageKey(), subKey);
    }
}
