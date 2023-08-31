package net.nordryd.nordmod.datagen;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.datagen.providers.ModBlockStateProvider;
import net.nordryd.nordmod.datagen.providers.ModBlockTagsProvider;
import net.nordryd.nordmod.datagen.providers.ModItemModelProvider;
import net.nordryd.nordmod.datagen.providers.ModLootTableProvider;
import net.nordryd.nordmod.datagen.providers.ModRecipeProvider;

/**
 * To generate everything defined here, find the {@code runData} gradle task in the forgegradle runs folder.
 */
@Mod.EventBusSubscriber(modid = NordMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators
{

    // This method fires at the "GatherData" event.
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent gdEvent) {
        final DataGenerator dataGenerator = gdEvent.getGenerator();
        final PackOutput packOutput = dataGenerator.getPackOutput();
        final ExistingFileHelper existingFileHelper = gdEvent.getExistingFileHelper();
        final CompletableFuture<HolderLookup.Provider> lookupProvider = gdEvent.getLookupProvider();

        dataGenerator.addProvider(gdEvent.includeServer(), new ModRecipeProvider(packOutput));
        dataGenerator.addProvider(gdEvent.includeServer(), ModLootTableProvider.create(packOutput));
        dataGenerator.addProvider(gdEvent.includeServer(),
                new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        dataGenerator.addProvider(gdEvent.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(gdEvent.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
    }
}
