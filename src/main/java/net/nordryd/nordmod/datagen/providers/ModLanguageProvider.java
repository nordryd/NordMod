package net.nordryd.nordmod.datagen.providers;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.block.ModBlocks;
import net.nordryd.nordmod.item.ModItems;

public class ModLanguageProvider extends LanguageProvider
{

    public ModLanguageProvider(final PackOutput output) {
        super(output, NordMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.ALEXANDRITE.get(), "Alexandrite");
        add(ModItems.RAW_ALEXANDRITE.get(), "Raw Alexandrite");
        add(ModItems.KOHLRABI.get(), "Kohlrabi");
        add(ModItems.PEAT_BRICK.get(), "Peat Brick");
        add(ModItems.METAL_DETECTOR.get(), "Metal Detector");

        add(ModBlocks.ALEXANDRITE_BLOCK.get(), "Alexandrite Block");
        add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get(), "Raw Alexandrite Block");
        add(ModBlocks.ALEXANDRITE_ORE.get(), "Alexandrite Ore");
        add(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), "Deepslate Alexandrite Ore");
        add(ModBlocks.NETHERRACK_ALEXANDRITE_ORE.get(), "Netherrack Alexandrite Ore");
        add(ModBlocks.ENDSTONE_ALEXANDRITE_ORE.get(), "Endstone Alexandrite Ore");
        add(ModBlocks.SOUND_BLOCK.get(), "Sound Block");
        add(ModBlocks.ALEXANDRITE_STAIRS.get(), "Alexandrite Stairs");
        add(ModBlocks.ALEXANDRITE_SLAB.get(), "Alexandrite Slab");
        add(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), "Alexandrite Pressure Plate");
        add(ModBlocks.ALEXANDRITE_BUTTON.get(), "Alexandrite Button");
        add(ModBlocks.ALEXANDRITE_FENCE.get(), "Alexandrite Fence");
        add(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), "Alexandrite Fence Gate");
        add(ModBlocks.ALEXANDRITE_WALL.get(), "Alexandrite Wall");

        addCreativeTab("nordmod_items_tab", "NordMod Items");
        addCreativeTab("nordmod_blocks_tab", "NordMod Blocks");

        addTooltip(ModItems.METAL_DETECTOR.get(), "Press SHIFT for more info");
        addTooltip(ModItems.METAL_DETECTOR.get(), "shift", "Right-click on blocks to find valuables below!");
        addTooltip(ModBlocks.SOUND_BLOCK.get(),
                "Plays sounds when walking or right-clicking. Try crouching and right-clicking!");

        addExtra(ModItems.METAL_DETECTOR.get(), "no_valuables_found", "No valuable metals found.");
        addExtra(ModItems.METAL_DETECTOR.get(), "valuable_found", "%s found at (%s, %s, %s)!");
    }

    private void addCreativeTab(final String key, final String translation) {
        add("creativemodetab." + NordMod.MOD_ID + "." + key, translation);
    }

    private void addTooltip(final Item item, final String translation) {
        addExtra(item, "tooltip", translation);
    }

    private void addTooltip(final Item item, final String tooltipSubKey, final String translation) {
        addExtra(item, "tooltip." + tooltipSubKey, translation);
    }

    private void addTooltip(final Block block, final String translation) {
        addExtra(block, "tooltip", translation);
    }

    private void addTooltip(final Block block, final String tooltipSubKey, final String translation) {
        addExtra(block, "tooltip." + tooltipSubKey, translation);
    }

    private void addExtra(final Item item, final String key, final String translation) {
        add(item.getDescriptionId() + "." + key, translation);
    }

    private void addExtra(final Block block, final String key, final String translation) {
        add(block.getDescriptionId() + "." + key, translation);
    }
}
