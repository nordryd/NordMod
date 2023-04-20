package net.nordryd.nordmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.nordryd.nordmod.NordMod;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NordMod.MOD_ID);

    public static final ModItem CITRINE = new ModItem("citrine", new Item.Properties().tab(CreativeModeTab.TAB_MISC));
    public static final ModItem RAW_CITRINE = new ModItem("raw_citrine", new Item.Properties().tab(CreativeModeTab.TAB_MISC));

    public static void register(final IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static class ModItem extends Item
    {
        private ModItem(final String id, final Item.Properties itemProperties) {
            super(itemProperties);
            ITEMS.register(id, () -> this);
        }
    }
}
