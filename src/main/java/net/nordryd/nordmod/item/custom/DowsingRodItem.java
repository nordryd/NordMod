package net.nordryd.nordmod.item.custom;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.nordryd.nordmod.item.ModItem;

/**
 * Click on a block with this item, and it will tell you if any block below it is a valuable block and output the coordinates.
 */
public class DowsingRodItem extends ModItem
{
    public DowsingRodItem(final String name, final Properties properties) {
        super(name, properties);
    }

    @Override
    public InteractionResult useOn(final UseOnContext useOnContext) {
        // isClientSide ensures that this executed on the client side (we don't wanna broadcast this to the whole server)
        if (useOnContext.getLevel().isClientSide()) {
            final BlockPos positionClicked = useOnContext.getClickedPos();
            final Player player = useOnContext.getPlayer();

            final int blocksBelowToWorldBottom = positionClicked.getY() + 64;
            int blocksBelow = 0;
            boolean foundBlock = false;

            while (!foundBlock && blocksBelow <= blocksBelowToWorldBottom) {
                final Block blockBelow = useOnContext.getLevel().getBlockState(positionClicked.below(blocksBelow)).getBlock();

                if (isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(blocksBelow), player, blockBelow);
                    foundBlock = true;
                }
                else {
                    blocksBelow++;
                }
            }

            if (!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.nordmod.dowsing_rod.no_valuables"), player.getUUID());
            }
        }

        useOnContext.getItemInHand()
                .hurtAndBreak(1, useOnContext.getPlayer(), (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(useOnContext);
    }

    private void outputValuableCoordinates(final BlockPos blockPos, final Player player, final Block blockBelow) {
        player.sendMessage(new TextComponent(
                String.format("There's %s at (%d, %d, %d)!", blockBelow.getName().getString(), blockPos.getX(), blockPos.getY(),
                        blockPos.getZ())), player.getUUID());
    }

    private boolean isValuableBlock(final Block block) {
        return List.of(Blocks.COAL_ORE, Blocks.DIAMOND_ORE, Blocks.COPPER_ORE, Blocks.IRON_ORE).contains(block);
    }
}
