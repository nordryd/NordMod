package net.nordryd.nordmod.datagen.providers;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.block.ModBlocks;
import net.nordryd.nordmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable final ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NordMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(final HolderLookup.Provider pProvider) {
        // Tags can include other tags. Tags.Blocks.ORES already has all the ores we're interested in
        // so we just need to add our mod ore and we're good to go.
        tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES).add(ModBlocks.ALEXANDRITE_ORE.get())
                .addTag(Tags.Blocks.ORES);

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get())
                .add(ModBlocks.NETHERRACK_ALEXANDRITE_ORE.get())
                .add(ModBlocks.ENDSTONE_ALEXANDRITE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_STAIRS.get())
                .add(ModBlocks.ALEXANDRITE_SLAB.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get())
                .add(ModBlocks.NETHERRACK_ALEXANDRITE_ORE.get())
                .add(ModBlocks.ENDSTONE_ALEXANDRITE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_STAIRS.get())
                .add(ModBlocks.ALEXANDRITE_SLAB.get());

        tag(BlockTags.FENCES).add(ModBlocks.ALEXANDRITE_FENCE.get());
        tag(BlockTags.WALLS).add(ModBlocks.ALEXANDRITE_WALL.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
