package net.nordryd.nordmod.datagen.providers;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
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
        simpleBlockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        simpleBlockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        simpleBlockWithItem(ModBlocks.ALEXANDRITE_ORE);
        simpleBlockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        simpleBlockWithItem(ModBlocks.NETHERRACK_ALEXANDRITE_ORE);
        simpleBlockWithItem(ModBlocks.ENDSTONE_ALEXANDRITE_ORE);

        simpleBlockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.ALEXANDRITE_STAIRS.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.ALEXANDRITE_SLAB.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()),
                blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);

        buttonBlock((ButtonBlock) ModBlocks.ALEXANDRITE_BUTTON.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(),
                blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
    }

    private void blockItem(final RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(
                ModNamespaceFactory.getModNamespaceBlockPath() + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())
                        .getPath()));
    }

    private void simpleBlockWithItem(final RegistryObject<Block> blockRegistryObject) {
        final Block block = blockRegistryObject.get();
        simpleBlockWithItem(block, cubeAll(block));
    }
}
