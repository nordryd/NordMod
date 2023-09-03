package net.nordryd.nordmod.datagen.loot;

import java.util.Set;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.nordryd.nordmod.block.ModBlocks;
import net.nordryd.nordmod.item.ModItems;

public class ModBlockLootTables extends BlockLootSubProvider
{
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    /**
     * If a block is created, it MUST have a loot table defined here unless it's built with the
     * {@code noLootTable()} builder method. Otherwise, an error will be thrown.
     */
    @Override
    protected void generate() {
        dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.SOUND_BLOCK.get());
        dropSelf(ModBlocks.ALEXANDRITE_STAIRS.get());
        dropSelf(ModBlocks.SOUND_BLOCK.get());
        dropSelf(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.ALEXANDRITE_BUTTON.get());
        dropSelf(ModBlocks.ALEXANDRITE_FENCE.get());
        dropSelf(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
        dropSelf(ModBlocks.ALEXANDRITE_WALL.get());

        add(ModBlocks.ALEXANDRITE_ORE.get(),
                block -> createOreDrop(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));
        add(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));
        add(ModBlocks.NETHERRACK_ALEXANDRITE_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHERRACK_ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));
        add(ModBlocks.ENDSTONE_ALEXANDRITE_ORE.get(),
                block -> createOreDrop(ModBlocks.ENDSTONE_ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));

        add(ModBlocks.ALEXANDRITE_SLAB.get(), block -> createSlabItemTable(ModBlocks.ALEXANDRITE_SLAB.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.MOD_BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)::iterator;
    }
}
