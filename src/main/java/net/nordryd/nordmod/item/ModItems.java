package net.nordryd.nordmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.item.custom.DowsingRodItem;
import net.nordryd.nordmod.item.custom.ModFuel;
import net.nordryd.nordmod.item.custom.RedactedItem;
import net.nordryd.nordmod.misc.ModCreativeModeTab;

public abstract class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NordMod.MOD_ID);

    public static final Item CITRINE = new ModItem("citrine", new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB));
    public static final Item RAW_CITRINE = new ModItem("raw_citrine", new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB));

    public static final Item CUCUMBER = new ModItem("cucumber",
            new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB).food(ModFoods.CUCUMBER));
    public static final Item CHILI_PEPPER = new ModItem("chili_pepper",
            new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB).food(ModFoods.CHILI_PEPPER));

    public static final Item COAL_COKE = new ModFuel("coal_coke", 3200,
            new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB));

    public static final Item DOWSING_ROD = new DowsingRodItem("dowsing_rod",
            new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB).durability(16));
    public static final Item REDACTED = new RedactedItem("redacted", new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB));

    public static void register(final IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
