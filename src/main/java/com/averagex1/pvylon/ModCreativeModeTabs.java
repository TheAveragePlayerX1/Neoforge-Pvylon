package com.averagex1.pvylon;

import com.averagex1.pvylon.block.ModBlocks;
import com.averagex1.pvylon.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Pvylon.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PVYLON_MISCHELLANEOUS_TAB = CREATIVE_MODE_TABS.register("pvylon_mischellaneous_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("Pvylon Mischellaneous"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> new ItemStack(ModItems.SILVER.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
        eventBus.addListener(ModCreativeModeTabs::addCreative);
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == PVYLON_MISCHELLANEOUS_TAB.getKey()) {
            ModItems.ITEMS.getEntries().forEach(holder -> event.accept(holder.get()));
        }
    }
}
