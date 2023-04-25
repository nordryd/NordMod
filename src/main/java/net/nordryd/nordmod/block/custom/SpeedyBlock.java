package net.nordryd.nordmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.nordryd.nordmod.block.ModBlock;

/**
 * Applies a SPEED effect to an entity that steps on it.
 */
public class SpeedyBlock extends ModBlock
{
    public SpeedyBlock(final String name, final CreativeModeTab creativeModeTab, final Properties blockProperties, final String tooltipKey) {
        super(name, creativeModeTab, blockProperties, tooltipKey);
    }

    @Override
    public void stepOn(final Level level, final BlockPos blockPos, final BlockState blockState, final Entity entity) {
        if (!level.isClientSide()) {
            if (entity instanceof final LivingEntity livingEntity) {
                if (!livingEntity.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300));
                }
            }
        }

        super.stepOn(level, blockPos, blockState, entity);
    }
}
