package net.nordryd.nordmod.misc;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nordryd.nordmod.item.ModItems;

public abstract class ModCreativeModeTab
{
    public static final CreativeModeTab NORDMOD_TAB = new CreativeModeTab("nordmod_tab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CITRINE);
        }
    };
}
