package net.nordryd.nordmod.block.custom;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nordryd.nordmod.util.ModLanguageKeyFactory;
import org.jetbrains.annotations.Nullable;

public class SoundBlock extends Block
{
    public SoundBlock(final Properties blockProperties) {
        super(blockProperties);
    }

    /**
     * This is called four times, twice for each hand for client and server
     * interactionHand.MAIN_HAND, pLevel.isClientSide
     * interactionHand.OFF_HAND, pLevel.isClientSide
     * interactionHand.MAIN_HAND, pLevel.isServerSide
     * interactionHand.OFF_HAND, pLevel.isServerSide
     * <p>
     * playSound plays a sound on the server to all nearby except the given player (which is why we pass null for the
     * first param)
     */
    @Override
    public InteractionResult use(final BlockState pBlockState, final Level pLevel, final BlockPos pBlockPos,
            final Player pPlayer, final InteractionHand pHand, final BlockHitResult pHitResult) {
        if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            if (pPlayer.isCrouching()) {
                pLevel.playSound(null, pBlockPos, SoundEvents.NOTE_BLOCK_BANJO.get(), SoundSource.BLOCKS, 1f, 1f);
                return InteractionResult.SUCCESS;
            }
            else {
                pLevel.playSound(null, pBlockPos, SoundEvents.NOTE_BLOCK_COW_BELL.get(), SoundSource.BLOCKS, 1f, 1f);
                return InteractionResult.CONSUME; // consumes what would've happened, so a block placed will not be placed
            }
        }

        return super.use(pBlockState, pLevel, pBlockPos, pPlayer, pHand, pHitResult);
    }

    @Override
    public void appendHoverText(final ItemStack pItemStack, @Nullable final BlockGetter pBlockGetter,
            final List<Component> pTooltip, final TooltipFlag pAdvanced) {
        pTooltip.add(Component.translatable(ModLanguageKeyFactory.getKey(this, "tooltip")));
        super.appendHoverText(pItemStack, pBlockGetter, pTooltip, pAdvanced);
    }

    @Override
    public void stepOn(final Level pLevel, final BlockPos pBlockPos, final BlockState pBlockState,
            final Entity pEntity) {
        pLevel.playSound(pEntity, pBlockPos, SoundEvents.NOTE_BLOCK_BIT.get(), SoundSource.BLOCKS, 1f, 1f);
        super.stepOn(pLevel, pBlockPos, pBlockState, pEntity);
    }
}
