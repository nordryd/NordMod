package net.nordryd.nordmod.registry;

import net.minecraftforge.eventbus.api.IEventBus;
import net.nordryd.nordmod.block.ModBlocks;
import net.nordryd.nordmod.creativeTabs.ModCreativeModeTabs;
import net.nordryd.nordmod.item.ModItems;

public abstract class RegistryHandler
{
    public static void registerModItems(final IEventBus eventBus) {
        ModItems.MOD_ITEMS.register(eventBus);
    }

    public static void registerBlocks(final IEventBus eventBus) {
        ModBlocks.MOD_BLOCKS.register(eventBus);
    }

    public static void registerCreativeTabs(final IEventBus eventBus) {
        ModCreativeModeTabs.MOD_CREATIVE_MODE_TABS.register(eventBus);
    }
}
