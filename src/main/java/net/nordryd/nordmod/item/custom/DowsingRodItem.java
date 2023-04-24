package net.nordryd.nordmod.item.custom;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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
        if(useOnContext.getLevel().isClientSide()) {
            final BlockPos positionClicked = useOnContext.getClickedPos();
            final Player player = useOnContext.getPlayer();
            boolean foundBlock = false;

            // can we add sounds to this to add flair?

            // From positionClicked - 0 to positionClicked - (positionClicked + 64)
            // This will iterate all the way down to Y = 0, and then 64 more blocks down because there's 64 more blocks below
            // Y = 0 as of 1.18.
            // change to a while loop to be a little cleaner
            for(int blockY = 0; blockY <= positionClicked.getY() + 64; blockY++) {
                final Block blockBelow = useOnContext.getLevel().getBlockState(positionClicked.below(blockY)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(blockY), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }

            // TODO use foundBlock as the while loop conditional to make this a bit cleaner

            if(!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.nordmod.dowsing_rod.no_valuables"),
                        player.getUUID());
            }
        }

        // Damage the item the player is holding by 1. If broken, then we broadcast a break event for the item used.
        useOnContext.getItemInHand().hurtAndBreak(1, useOnContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(useOnContext);
    }

    private void outputValuableCoordinates(final BlockPos blockPos, final Player player, final Block blockBelow) {
        player.sendMessage(new TextComponent(
                String.format("Found %s at (%d, %d, %d)", blockBelow.asItem().getRegistryName().toString(), blockPos.getX(),
                        blockPos.getY(), blockPos.getZ())), player.getUUID());
    }

    private boolean isValuableBlock(final Block block) {
        return List.of(Blocks.COAL_ORE, Blocks.DIAMOND_ORE, Blocks.COPPER_ORE, Blocks.IRON_ORE).contains(block);
    }
}
