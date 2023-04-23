package net.nordryd.nordmod.block;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.item.ModItems;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NordMod.MOD_ID);

    // material = sound effects?
    // strength = time to break block (what are some references for perspective?)

    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops()),
            CreativeModeTab.TAB_MISC);

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> blockSupplier,
            final CreativeModeTab creativeTab) {
        final RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, block, creativeTab);
        return block;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(final String name, final RegistryObject<T> block,
            final CreativeModeTab creativeTab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(creativeTab)));
    }

    public static void register(final IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
