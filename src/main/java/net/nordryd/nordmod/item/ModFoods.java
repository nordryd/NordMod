package net.nordryd.nordmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public abstract class ModFoods
{
    public static final FoodProperties CUCUMBER = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties CHILI_PEPPER = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 0.3F).build();
}
