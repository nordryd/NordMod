package net.nordryd.nordmod.datagen.providers;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.block.ModBlocks;
import net.nordryd.nordmod.util.ModNamespaceFactory;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(final PackOutput output, final ExistingFileHelper exFileHelper) {
        super(output, NordMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        this.simpleBlockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        this.simpleBlockWithItem(ModBlocks.ALEXANDRITE_ORE);
        this.simpleBlockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        this.simpleBlockWithItem(ModBlocks.NETHERRACK_ALEXANDRITE_ORE);
        this.simpleBlockWithItem(ModBlocks.ENDSTONE_ALEXANDRITE_ORE);

        simpleBlockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.ALEXANDRITE_STAIRS.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.ALEXANDRITE_SLAB.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()),
                blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);
    }

    private void blockItem(final RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(
                ModNamespaceFactory.getModBlockNamespace() + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())
                        .getPath()));
    }

    private void simpleBlockWithItem(final RegistryObject<Block> blockRegistryObject) {
        final Block block = blockRegistryObject.get();
        simpleBlockWithItem(block, cubeAll(block));
    }
}
