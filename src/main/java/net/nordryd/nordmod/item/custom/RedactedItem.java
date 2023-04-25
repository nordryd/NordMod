package net.nordryd.nordmod.item.custom;

import java.util.Random;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nordryd.nordmod.item.ModItem;

public class RedactedItem extends ModItem
{
    public RedactedItem(final String name, final Properties itemProperties) {
        super(name, itemProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(final Level level, final Player player, final InteractionHand usedHand) {
        final Random rng = new Random();
        if (level.isClientSide()) {
            level.playLocalSound(player.getX(), player.getY(), player.getZ(), SoundEvents.AMBIENT_CAVE, SoundSource.NEUTRAL, 0.6f,
                    rng.nextFloat(), false);
            player.sendMessage(new TranslatableComponent("item.nordmod.redacted.redacted" + rng.nextInt(3)), player.getUUID());
        }

        return super.use(level, player, usedHand);
    }
}
