package net.nordryd.nordmod.item;

import net.minecraft.world.item.Item;

public class ModItem extends Item
{
    public ModItem(final String name, final Properties itemProperties) {
        super(itemProperties);
        ModItems.ITEMS.register(name, () -> this);
    }
}
