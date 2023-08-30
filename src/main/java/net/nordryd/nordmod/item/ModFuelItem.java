package net.nordryd.nordmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class ModFuelItem extends Item
{
    private final int burnTime;

    public ModFuelItem(final Properties pProperties, final int pBurnTime) {
        super(pProperties);
        this.burnTime = pBurnTime;
    }

    @Override
    public int getBurnTime(final ItemStack itemStack, @Nullable final RecipeType<?> recipeType) {
        return burnTime;
    }
}
