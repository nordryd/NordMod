package net.nordryd.nordmod.block;

import java.util.function.Supplier;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.block.custom.SoundBlock;
import net.nordryd.nordmod.item.ModItems;

public class ModBlocks
{
    public static final DeferredRegister<Block> MOD_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            NordMod.MOD_ID);

    // Standard blocks
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerModBlock("alexandrite_block", () -> new Block(
            BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .sound(SoundType.AMETHYST)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerModBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .requiresCorrectToolForDrops()));

    // Ores
    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerModBlock("alexandrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_ALEXANDRITE_ORE = registerModBlock("deepslate_alexandrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f)
                    .requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHERRACK_ALEXANDRITE_ORE = registerModBlock(
            "netherrack_alexandrite_ore", () -> new DropExperienceBlock(
                    BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                            .strength(5f)
                            .requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> ENDSTONE_ALEXANDRITE_ORE = registerModBlock("endstone_alexandrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops(), UniformInt.of(5, 8)));

    // Stairs and slabs
    public static final RegistryObject<Block> ALEXANDRITE_STAIRS = registerModBlock("alexandrite_stairs",
            () -> new StairBlock(ALEXANDRITE_BLOCK.get()
                    .defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PRISMARINE_STAIRS)
                    .sound(SoundType.AMETHYST)
                    .strength(5f)));
    public static final RegistryObject<Block> ALEXANDRITE_SLAB = registerModBlock("alexandrite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE_SLAB)
                    .sound(SoundType.AMETHYST)
                    .strength(5f)));
    public static final RegistryObject<Block> ALEXANDRITE_PRESSURE_PLATE = registerModBlock(
            "alexandrite_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.PRISMARINE)
                            .sound(SoundType.AMETHYST), BlockSetType.IRON));
    public static final RegistryObject<Block> ALEXANDRITE_BUTTON = registerModBlock("alexandrite_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)
                    .sound(SoundType.AMETHYST)
                    .strength(5f), BlockSetType.IRON, 10, true));

    // Advanced blocks
    public static final RegistryObject<Block> SOUND_BLOCK = registerModBlock("sound_block", () -> new SoundBlock(
            BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f)));

    private static <T extends Block> RegistryObject<T> registerModBlock(final String name,
            final Supplier<T> blockSupplier) {
        final RegistryObject<T> block = MOD_BLOCKS.register(name, blockSupplier);
        registerModBlockAsBlockItem(name, block);
        return block;
    }

    private static <T extends Block> void registerModBlockAsBlockItem(final String name,
            final RegistryObject<T> block) {
        ModItems.MOD_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
