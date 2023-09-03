package net.nordryd.nordmod.creativeTabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.block.ModBlocks;
import net.nordryd.nordmod.item.ModItems;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> MOD_CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, NordMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> NORDMOD_ITEMS_TAB = MOD_CREATIVE_MODE_TABS.register(
            "nordmod_items_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .title(Component.translatable("creativemodetab.nordmod.nordmod_items_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ALEXANDRITE.get());
                        output.accept(ModItems.RAW_ALEXANDRITE.get());
                        output.accept(ModItems.KOHLRABI.get());
                        output.accept(ModItems.PEAT_BRICK.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> NORDMOD_BLOCKS_TAB = MOD_CREATIVE_MODE_TABS.register(
            "nordmod_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .title(Component.translatable("creativemodetab.nordmod.nordmod_blocks_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.NETHERRACK_ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.ENDSTONE_ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.SOUND_BLOCK.get());
                        output.accept(ModBlocks.ALEXANDRITE_STAIRS.get());
                        output.accept(ModBlocks.ALEXANDRITE_SLAB.get());
                        output.accept(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ALEXANDRITE_BUTTON.get());
                        output.accept(ModBlocks.ALEXANDRITE_FENCE.get());
                        output.accept(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
                        output.accept(ModBlocks.ALEXANDRITE_WALL.get());
                    }).build());
}
