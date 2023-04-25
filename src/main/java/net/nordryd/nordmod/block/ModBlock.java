package net.nordryd.nordmod.block;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.nordryd.nordmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class ModBlock extends Block
{
    public ModBlock(final String name, final CreativeModeTab creativeModeTab, final Properties blockProperties) {
        super(blockProperties);
        ModBlocks.BLOCKS.register(name, () -> this);
        ModItems.ITEMS.register(name, () -> new BlockItem(this, new Item.Properties().tab(creativeModeTab)));
    }

    public ModBlock(final String name, final CreativeModeTab creativeModeTab, final Properties blockProperties,
            final String tooltipKey) {
        super(blockProperties);
        ModBlocks.BLOCKS.register(name, () -> this);
        ModItems.ITEMS.register(name, () -> new BlockItem(this, new Item.Properties().tab(creativeModeTab))
        {
            @Override
            public void appendHoverText(final ItemStack itemStack, @Nullable final Level level,
                    final List<Component> tooltipComponents, final TooltipFlag tooltipFlag) {
                tooltipComponents.add(new TranslatableComponent(tooltipKey));
            }
        });
    }
}
