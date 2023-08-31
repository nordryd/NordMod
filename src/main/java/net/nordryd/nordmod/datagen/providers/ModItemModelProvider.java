package net.nordryd.nordmod.datagen.providers;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.item.ModItems;

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
    }

    private ItemModelBuilder simpleItem(final RegistryObject<Item> itemRegistryObject) {
        return withExistingParent(itemRegistryObject.getId()
                .getPath(), new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NordMod.MOD_ID, "item/" + itemRegistryObject.getId()
                        .getPath()));
    }
}
