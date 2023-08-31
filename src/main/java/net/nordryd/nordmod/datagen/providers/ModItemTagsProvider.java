package net.nordryd.nordmod.datagen.providers;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nordryd.nordmod.NordMod;
import org.jetbrains.annotations.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider
{
    public ModItemTagsProvider(final PackOutput packOutput, final CompletableFuture<HolderLookup.Provider> holderLookup,
            final CompletableFuture<TagLookup<Block>> blockTagLookup,
            @Nullable final ExistingFileHelper existingFileHelper) {
        super(packOutput, holderLookup, blockTagLookup, NordMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(final HolderLookup.Provider pProvider) {
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
