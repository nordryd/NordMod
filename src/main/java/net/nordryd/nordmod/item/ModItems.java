package net.nordryd.nordmod.item;

import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nordryd.nordmod.NordMod;

public class ModItems
{
    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            NordMod.MOD_ID);
    public static final RegistryObject<Item> ALEXANDRITE = registerModItem("alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = registerModItem("raw_alexandrite",
            () -> new Item(new Item.Properties()));
    private static <T extends Item> RegistryObject<T> registerModItem(final String name,
            final Supplier<T> itemSupplier) {
        return MOD_ITEMS.register(name, itemSupplier);
    }
}
