package net.nordryd.nordmod.item.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.nordryd.nordmod.item.ModItem;
import org.jetbrains.annotations.Nullable;

public class ModFuel extends ModItem
{
    private final int burnTime;

    /**
     * burnTime = How long it'll burn in game ticks (1 second = 20 ticks)
     */
    public ModFuel(final String name, final int burnTime, final Properties properties) {
        super(name, properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(final ItemStack itemStack, @Nullable final RecipeType<?> recipeType) {
        return burnTime;
    }
}
