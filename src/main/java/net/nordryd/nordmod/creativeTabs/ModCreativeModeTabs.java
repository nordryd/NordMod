package net.nordryd.nordmod.creativeTabs;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.item.ModItems;

@Mod.EventBusSubscriber(modid = NordMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs
{
    public static CreativeModeTab NORDMOD_ITEMS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(final CreativeModeTabEvent.Register event) {
        NORDMOD_ITEMS = event.registerCreativeModeTab(new ResourceLocation(NordMod.MOD_ID, "nordmod_items"),
                builder -> builder.icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                        .title(Component.translatable("creativemodetab.nordmod_items")));
    }
}
