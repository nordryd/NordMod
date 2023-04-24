package net.nordryd.nordmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.nordryd.nordmod.item.ModItems;

public class ModBlock extends Block
{
    public ModBlock(final String name, final CreativeModeTab creativeModeTab, final BlockBehaviour.Properties blockProperties) {
        super(blockProperties);
        ModBlocks.BLOCKS.register(name, () -> this);
        ModItems.ITEMS.register(name, () -> new BlockItem(this, new Item.Properties().tab(creativeModeTab)));
    }
}
