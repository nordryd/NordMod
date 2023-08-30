package net.nordryd.nordmod.item.custom;

import java.util.List;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item
{
    public MetalDetectorItem(final Properties itemProperties) {
        super(itemProperties);
    }

    @Override
    public InteractionResult useOn(final UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            final BlockPos positionClicked = pContext.getClickedPos();
            final Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int blocksBelow = 0; blocksBelow <= positionClicked.getY() && !foundBlock; blocksBelow++) {
                final BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(blocksBelow));
                if (isValuableBlock(blockState.getBlock())) {
                    outputValuableMetalPosition(positionClicked.below(blocksBelow), player, blockState.getBlock());
                    foundBlock = true;
                }
            }

            if (!foundBlock) {
                outputNoValuableFound(player);
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputNoValuableFound(final Player player) {
        player.sendSystemMessage(Component.translatable("item.nordmod.metal_detector.no_valuables_found"));
    }

    private void outputValuableMetalPosition(final BlockPos blockPos, final Player player, final Block block) {
        player.sendSystemMessage(
                Component.translatable("item.nordmod.metal_detector.valuable_found", I18n.get(block.getDescriptionId()),
                        blockPos.getX(), blockPos.getY(), blockPos.getZ()));
    }

    private boolean isValuableBlock(final Block block) {
        return List.of(Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE,
                        Blocks.GOLD_BLOCK, Blocks.DEEPSLATE_GOLD_ORE, Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE)
                .contains(block);
    }
}
