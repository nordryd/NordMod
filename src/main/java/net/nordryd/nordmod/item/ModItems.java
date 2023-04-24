package net.nordryd.nordmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.misc.ModCreativeModeTab;

public abstract class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NordMod.MOD_ID);

    public static final Item CITRINE = new ModItem("citrine", new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB));
    public static final Item RAW_CITRINE = new ModItem("raw_citrine", new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB));

    public static void register(final IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
