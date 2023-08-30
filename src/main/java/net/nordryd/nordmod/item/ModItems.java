package net.nordryd.nordmod.item;

import java.util.function.Supplier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.item.custom.MetalDetectorItem;

public class ModItems
{
    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            NordMod.MOD_ID);
    public static final RegistryObject<Item> ALEXANDRITE = registerModItem("alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = registerModItem("raw_alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KOHLRABI = registerModItem("kohlrabi", () -> new Item(
            new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(2.5f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build())));

    public static final RegistryObject<Item> PEAT_BRICK = registerModItem("peat_brick",
            () -> new ModFuelItem(new Item.Properties(), 200));

    public static final RegistryObject<Item> METAL_DETECTOR = registerModItem("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(512)));

    private static <T extends Item> RegistryObject<T> registerModItem(final String name,
            final Supplier<T> itemSupplier) {
        return MOD_ITEMS.register(name, itemSupplier);
    }
}
