package com.averagex1.pvylon;

import com.averagex1.pvylon.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Pvylon.MODID)
public class Pvylon {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "neoforgepvylonprojectone";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.examplemod")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Pvylon(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // Add the example block item to the ingredients tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ACTIVATOR_SHARD);
            event.accept(ModItems.ANCIENT_SHARD);
            event.accept(ModItems.BATTERY);
            event.accept(ModItems.BLACKBONE);
            event.accept(ModItems.BORS_CLAW);
            event.accept(ModItems.CELESTIAL_SILVER);
            event.accept(ModItems.CLANKER_HEART);
            event.accept(ModItems.COPPER_DUST);
            event.accept(ModItems.COPPER_THREAD);
            event.accept(ModItems.CORRUPT_POWERSTONE_TIER_1);
            event.accept(ModItems.CORRUPT_POWERSTONE_TIER_2);
            event.accept(ModItems.CORRUPT_POWERSTONE_TIER_3);
            event.accept(ModItems.CORRUPT_POWERSTONE_TIER_4);
            event.accept(ModItems.CORRUPT_POWERSTONE_TIER_5);
            event.accept(ModItems.CORRUPT_POWERSTONE_TIER_6);
            event.accept(ModItems.CORRUPT_POWERSTONE_TIER_7);
            event.accept(ModItems.CORRUPT_POWERSTONE_TIER_8);
            event.accept(ModItems.CORRUPT_POWERSTONE_TIER_9);
            event.accept(ModItems.DIAMOND_DUST);
            event.accept(ModItems.DIVINE_MEMBRANE);
            event.accept(ModItems.DREAM_WHEAT);
            event.accept(ModItems.ENDLESS_CITY_HEART);
            event.accept(ModItems.ENDLESS_SEA_HEART);
            event.accept(ModItems.ENDLESS_WASTELAND_HEART);
            event.accept(ModItems.EYE_OF_CTHULHU);
            event.accept(ModItems.GLASS_SHARD);
            event.accept(ModItems.GOLD_DUST);
            event.accept(ModItems.GOLD_HAND);
            event.accept(ModItems.GRAPHENE);
            event.accept(ModItems.IRON_BAR);
            event.accept(ModItems.IRON_DUST);
            event.accept(ModItems.LARGE_CASE);
            event.accept(ModItems.LARGE_SCREEN);
            event.accept(ModItems.LIGHT_CORE);
            event.accept(ModItems.MEDIUM_CASE);
            event.accept(ModItems.MEDIUM_SCREEN);
            event.accept(ModItems.MOTOR);
            event.accept(ModItems.NIGHTMARE_HEART);
            event.accept(ModItems.POWERSTONE_SCRAP);
            event.accept(ModItems.POWERSTONE_TIER_1);
            event.accept(ModItems.POWERSTONE_TIER_2);
            event.accept(ModItems.POWERSTONE_TIER_3);
            event.accept(ModItems.POWERSTONE_TIER_4);
            event.accept(ModItems.POWERSTONE_TIER_5);
            event.accept(ModItems.POWERSTONE_TIER_6);
            event.accept(ModItems.POWERSTONE_TIER_7);
            event.accept(ModItems.POWERSTONE_TIER_8);
            event.accept(ModItems.POWERSTONE_TIER_9);
            event.accept(ModItems.RADIANT_HEART);
            event.accept(ModItems.RAW_TRANITE);
            event.accept(ModItems.PURE_POWERSTONE_TIER_1);
            event.accept(ModItems.PURE_POWERSTONE_TIER_2);
            event.accept(ModItems.PURE_POWERSTONE_TIER_3);
            event.accept(ModItems.PURE_POWERSTONE_TIER_4);
            event.accept(ModItems.PURE_POWERSTONE_TIER_5);
            event.accept(ModItems.PURE_POWERSTONE_TIER_6);
            event.accept(ModItems.PURE_POWERSTONE_TIER_7);
            event.accept(ModItems.PURE_POWERSTONE_TIER_8);
            event.accept(ModItems.PURE_POWERSTONE_TIER_9);
            event.accept(ModItems.SEA_PEARL);
            event.accept(ModItems.SIZE_ONE_FISH);
            event.accept(ModItems.SIZE_TWO_FISH);
            event.accept(ModItems.SIZE_THREE_FISH);
            event.accept(ModItems.SIZE_FOUR_FISH);
            event.accept(ModItems.SIZE_FIVE_FISH);
            event.accept(ModItems.SIZE_SIX_FISH);
            event.accept(ModItems.SIZE_SEVEN_FISH);
            event.accept(ModItems.SIZE_EIGHT_FISH);
            event.accept(ModItems.SIZE_NINE_FISH);
            event.accept(ModItems.SIZE_TEN_FISH);
            event.accept(ModItems.SIZE_ELEVEN_FISH);
            event.accept(ModItems.SIZE_TWELVE_FISH);
            event.accept(ModItems.SHARP_NEEDLE);
            event.accept(ModItems.SILVER_DUST);
            event.accept(ModItems.SMALL_CASE);
            event.accept(ModItems.SMALL_SCREEN);
            event.accept(ModItems.SPRING);
            event.accept(ModItems.STEEL_SCRAP);
            event.accept(ModItems.SUSPICIOUS_HANDLE);
            event.accept(ModItems.THERMITE);
            event.accept(ModItems.TRANITE_DUST);
            event.accept(ModItems.TRANITE_INGOT);
            event.accept(ModItems.TRANITE_NUGGET);
            event.accept(ModItems.TRANSMUTATION_GEM);
            event.accept(ModItems.TUNGSTEN_DUST);
            event.accept(ModItems.VOID_HEART);
            event.accept(ModItems.WASTELAND_FABRIC);
            event.accept(ModItems.WIRES);
            event.accept(ModItems.SILVER);
            event.accept(ModItems.RAW_SILVER);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
