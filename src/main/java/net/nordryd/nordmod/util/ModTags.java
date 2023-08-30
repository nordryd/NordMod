package net.nordryd.nordmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.nordryd.nordmod.NordMod;

public class ModTags
{
    public static class Items
    {
        private static TagKey<Item> tag(final String name) {
            return ItemTags.create(new ResourceLocation(NordMod.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(final String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks
    {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");

        private static TagKey<Block> tag(final String name) {
            return BlockTags.create(new ResourceLocation(NordMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(final String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
