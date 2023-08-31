package net.nordryd.nordmod.datagen.providers;

import java.util.List;
import java.util.Set;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.nordryd.nordmod.datagen.loot.ModBlockLootTables;

public class ModLootTableProvider
{
    public static LootTableProvider create(final PackOutput packOutput) {
        return new LootTableProvider(packOutput, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
