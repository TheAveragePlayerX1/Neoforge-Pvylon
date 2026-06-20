package com.averagex1.pvylon.item;

import com.averagex1.pvylon.Pvylon;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Pvylon.MODID);

    public static final DeferredItem<Item> SILVER = ITEMS.register("silver",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TUNGSTEN = ITEMS.register("tungsten",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_WOLFRAMITE = ITEMS.register("raw_wolframite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ACTIVATOR_SHARD = ITEMS.register("activator_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ANCIENT_SHARD = ITEMS.register("ancient_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BATTERY = ITEMS.register("battery",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLACKBONE = ITEMS.register("blackbone",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BORS_CLAW = ITEMS.register("bors_claw",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CELESTIAL_SILVER = ITEMS.register("celestial_silver",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CLANKER_HEART = ITEMS.register("clanker_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPER_DUST = ITEMS.register("copper_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPER_THREAD = ITEMS.register("copper_thread",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_DUST = ITEMS.register("diamond_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DIVINE_MEMBRANE = ITEMS.register("divine_membrane",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DREAM_WHEAT = ITEMS.register("dream_wheat",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ENDLESS_CITY_HEART = ITEMS.register("endless_city_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ENDLESS_SEA_HEART = ITEMS.register("endless_sea_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ENDLESS_WASTELAND_HEART = ITEMS.register("endless_wasteland_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EYE_OF_CTHULHU = ITEMS.register("eye_of_cthulhu",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GLASS_SHARD = ITEMS.register("glass_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GOLD_DUST = ITEMS.register("gold_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GOLD_HAND = ITEMS.register("gold_hand",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GRAPHENE = ITEMS.register("graphene",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IRON_BAR = ITEMS.register("iron_bar",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IRON_DUST = ITEMS.register("iron_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LARGE_CASE = ITEMS.register("large_case",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LARGE_SCREEN = ITEMS.register("large_screen",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LIGHT_CORE = ITEMS.register("light_core",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MEDIUM_CASE = ITEMS.register("medium_case",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MEDIUM_SCREEN = ITEMS.register("medium_screen",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MOTOR = ITEMS.register("motor",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NIGHTMARE_HEART = ITEMS.register("nightmare_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POWERSTONE_SCRAP = ITEMS.register("powerstone_scrap",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RADIANT_HEART = ITEMS.register("radiant_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_TRANITE = ITEMS.register("raw_tranite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SEA_PEARL = ITEMS.register("sea_pearl",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHARP_NEEDLE = ITEMS.register("sharp_needle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SILVER_DUST = ITEMS.register("silver_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALL_CASE = ITEMS.register("small_case",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALL_SCREEN = ITEMS.register("small_screen",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPRING = ITEMS.register("spring",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STEEL_SCRAP = ITEMS.register("steel_scrap",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SUSPICIOUS_HANDLE = ITEMS.register("suspicious_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> THERMITE = ITEMS.register("thermite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TRANITE_DUST = ITEMS.register("tranite_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TRANITE_INGOT = ITEMS.register("tranite_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TRANITE_NUGGET = ITEMS.register("tranite_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TRANSMUTATION_GEM = ITEMS.register("transmutation_gem",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TUNGSTEN_DUST = ITEMS.register("tungsten_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> VOID_HEART = ITEMS.register("void_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WASTELAND_FABRIC = ITEMS.register("wasteland_fabric",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WIRES = ITEMS.register("wires",
            () -> new Item(new Item.Properties()));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
