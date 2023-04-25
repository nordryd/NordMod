package net.nordryd.nordmod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.block.custom.SpeedyBlock;
import net.nordryd.nordmod.misc.ModCreativeModeTab;

public abstract class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NordMod.MOD_ID);

    public static final Block CITRINE_BLOCK = new ModBlock("citrine_block", ModCreativeModeTab.NORDMOD_TAB,
            BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops());
    public static final Block RAW_CITRINE_BLOCK = new ModBlock("raw_citrine_block", ModCreativeModeTab.NORDMOD_TAB,
            BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops());
    public static final Block CITRINE_ORE = new ModBlock("citrine_ore", ModCreativeModeTab.NORDMOD_TAB,
            BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops());
    public static final Block DEEPSLATE_CITRINE_ORE = new ModBlock("deepslate_citrine_ore", ModCreativeModeTab.NORDMOD_TAB,
            BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops());
    public static final Block NETHERRACK_CITRINE_ORE = new ModBlock("netherrack_citrine_ore", ModCreativeModeTab.NORDMOD_TAB,
            BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops());
    public static final Block ENDSTONE_CITRINE_ORE = new ModBlock("endstone_citrine_ore", ModCreativeModeTab.NORDMOD_TAB,
            BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops());

    public static final Block SPEEDY_BLOCK = new SpeedyBlock("speedy_block", ModCreativeModeTab.NORDMOD_TAB,
            BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops());

    public static void register(final IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
