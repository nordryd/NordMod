package net.nordryd.nordmod.datagen.providers;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.block.ModBlocks;
import net.nordryd.nordmod.item.ModItems;
import net.nordryd.nordmod.util.ModNamespaceFactory;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(final PackOutput packOutput, final ExistingFileHelper existingFileHelper) {
        super(packOutput, NordMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ALEXANDRITE);
        simpleItem(ModItems.RAW_ALEXANDRITE);
        simpleItem(ModItems.KOHLRABI);
        simpleItem(ModItems.PEAT_BRICK);
        simpleItem(ModItems.METAL_DETECTOR);

        buttonItem(ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_BLOCK);
    }

    private void buttonItem(final RegistryObject<Block> buttonBlock, final RegistryObject<Block> baseTextureBlock) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(buttonBlock.get())
                .getPath(), mcLoc(ModNamespaceFactory.getBlockPath("button_inventory"))).texture("texture",
                new ResourceLocation(ModNamespaceFactory.getModNamespaceBlockPath() +
                        ForgeRegistries.BLOCKS.getKey(baseTextureBlock.get())
                                .getPath()));
    }

    private ItemModelBuilder simpleItem(final RegistryObject<Item> itemRegistryObject) {
        return withExistingParent(itemRegistryObject.getId()
                .getPath(), new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NordMod.MOD_ID, ModNamespaceFactory.getItemPath() + itemRegistryObject.getId()
                        .getPath()));
    }
}
