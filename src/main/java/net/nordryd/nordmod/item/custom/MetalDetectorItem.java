package net.nordryd.nordmod.item.custom;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.nordryd.nordmod.util.ModLanguageKeyFactory;
import net.nordryd.nordmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class MetalDetectorItem extends Item
{
    public MetalDetectorItem(final Properties itemProperties) {
        super(itemProperties);
    }

    @Override
    public InteractionResult useOn(final UseOnContext pContext) {
        if (!pContext.getLevel()
                .isClientSide()) {
            final BlockPos positionClicked = pContext.getClickedPos();
            final Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int blocksBelow = 0; blocksBelow <= positionClicked.getY() && !foundBlock; blocksBelow++) {
                final BlockState blockState = pContext.getLevel()
                        .getBlockState(positionClicked.below(blocksBelow));
                if (isValuableBlock(blockState)) {
                    outputValuableMetalPosition(positionClicked.below(blocksBelow), player, blockState.getBlock());
                    foundBlock = true;
                }
            }

            if (!foundBlock) {
                outputNoValuableFound(player);
            }
        }

        pContext.getItemInHand()
                .hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(final ItemStack pItemStack, @Nullable final Level pLevel,
            final List<Component> pTooltip, final TooltipFlag pAdvanced) {
        final String translationKey = ModLanguageKeyFactory.getKey(this);
        if (Screen.hasShiftDown()) {
            pTooltip.add(Component.translatable(translationKey + "tooltip.shift"));
        }
        else {
            pTooltip.add(Component.translatable(translationKey + "tooltip"));
        }
        super.appendHoverText(pItemStack, pLevel, pTooltip, pAdvanced);
    }

    private void outputNoValuableFound(final Player player) {
        player.sendSystemMessage(Component.translatable(ModLanguageKeyFactory.getKey(this) + "no_valuables_found"));
    }

    private void outputValuableMetalPosition(final BlockPos blockPos, final Player player, final Block block) {
        player.sendSystemMessage(Component.translatable(ModLanguageKeyFactory.getKey(this) + "valuable_found",
                I18n.get(block.getDescriptionId()), blockPos.getX(), blockPos.getY(), blockPos.getZ()));
    }

    private boolean isValuableBlock(final BlockState blockState) {
        return blockState.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }
}
