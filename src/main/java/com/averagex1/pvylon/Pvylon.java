package com.averagex1.pvylon;

import com.averagex1.pvylon.block.ModBlocks;
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

@Mod(Pvylon.MODID)
public class Pvylon {
    public static final String MODID = "neoforgepvylonprojectone";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.examplemod"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get());
            }).build());

    public Pvylon(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.BLACK_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.BLACK_DUNGEON_BLOCK);
            event.accept(ModBlocks.BLACK_DUNGEON_PILLAR);
            event.accept(ModBlocks.BLACK_DUNGEON_STAIRS);
            event.accept(ModBlocks.BLACK_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.BLACK_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.BLACK_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.BLACKBONE_BLOCK);
            event.accept(ModBlocks.BLUE_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.BLUE_DUNGEON_BLOCK);
            event.accept(ModBlocks.BLUE_DUNGEON_PILLAR);
            event.accept(ModBlocks.BLUE_DUNGEON_STAIRS);
            event.accept(ModBlocks.BLUE_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.BLUE_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.BLUE_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.BROWN_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.BROWN_DUNGEON_BLOCK);
            event.accept(ModBlocks.BROWN_DUNGEON_PILLAR);
            event.accept(ModBlocks.BROWN_DUNGEON_STAIRS);
            event.accept(ModBlocks.BROWN_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.BROWN_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.BROWN_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.CELESTIAL_BONE);
            event.accept(ModBlocks.CELESTIAL_SILVER_BLOCK);
            event.accept(ModBlocks.CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.CLOUD_BLOCK);
            event.accept(ModBlocks.COBBLED_DARKSTONE);
            event.accept(ModBlocks.COBBLED_LIGHTSTONE);
            event.accept(ModBlocks.CYAN_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.CYAN_DUNGEON_BLOCK);
            event.accept(ModBlocks.CYAN_DUNGEON_PILLAR);
            event.accept(ModBlocks.CYAN_DUNGEON_STAIRS);
            event.accept(ModBlocks.CYAN_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.CYAN_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.CYAN_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.DARKLANDS_FOREST_GRASS);
            event.accept(ModBlocks.DARKLANDS_MAHOGANY_LEAVES);
            event.accept(ModBlocks.DARKLANDS_MAHOGANY_PLANKS);
            event.accept(ModBlocks.DARKLANDS_MAHOGANY_WOOD);
            event.accept(ModBlocks.DARKSTONE);
            event.accept(ModBlocks.DARKSTONE_SLATE);
            event.accept(ModBlocks.DIAMOND_DUST_BLOCK);
            event.accept(ModBlocks.DREAM_DIRT);
            event.accept(ModBlocks.DREAM_DUST_BLOCK);
            event.accept(ModBlocks.DREAM_GLASS);
            event.accept(ModBlocks.DREAM_GRASS);
            event.accept(ModBlocks.DREAM_SAND);
            event.accept(ModBlocks.DUNGEON_GLASS);
            event.accept(ModBlocks.FAIRY_WILLOW_LEAVES);
            event.accept(ModBlocks.FAIRY_WILLOW_PLANKS);
            event.accept(ModBlocks.FAIRY_WILLOW_WOOD);
            event.accept(ModBlocks.GOLD_DUST_BLOCK);
            event.accept(ModBlocks.GRAPHENE_BLOCK);
            event.accept(ModBlocks.GRAY_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.GRAY_DUNGEON_BLOCK);
            event.accept(ModBlocks.GRAY_DUNGEON_PILLAR);
            event.accept(ModBlocks.GRAY_DUNGEON_STAIRS);
            event.accept(ModBlocks.GRAY_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.GRAY_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.GRAY_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.GREEN_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.GREEN_DUNGEON_BLOCK);
            event.accept(ModBlocks.GREEN_DUNGEON_PILLAR);
            event.accept(ModBlocks.GREEN_DUNGEON_STAIRS);
            event.accept(ModBlocks.GREEN_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.GREEN_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.GREEN_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.IRON_DUST_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_DUNGEON_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_DUNGEON_PILLAR);
            event.accept(ModBlocks.LIGHT_BLUE_DUNGEON_STAIRS);
            event.accept(ModBlocks.LIGHT_BLUE_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.LIGHT_BLUE_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.LIGHT_DIRT);
            event.accept(ModBlocks.LIGHT_FIELDS_GRASS);
            event.accept(ModBlocks.LIGHT_GRASS_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_DUNGEON_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_DUNGEON_PILLAR);
            event.accept(ModBlocks.LIGHT_GRAY_DUNGEON_STAIRS);
            event.accept(ModBlocks.LIGHT_GRAY_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.LIGHT_GRAY_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.LIGHTSTONE);
            event.accept(ModBlocks.LIME_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.LIME_DUNGEON_BLOCK);
            event.accept(ModBlocks.LIME_DUNGEON_PILLAR);
            event.accept(ModBlocks.LIME_DUNGEON_STAIRS);
            event.accept(ModBlocks.LIME_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.LIME_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.LIME_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.MAGENTA_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.MAGENTA_DUNGEON_BLOCK);
            event.accept(ModBlocks.MAGENTA_DUNGEON_PILLAR);
            event.accept(ModBlocks.MAGENTA_DUNGEON_STAIRS);
            event.accept(ModBlocks.MAGENTA_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.MAGENTA_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.MAGENTA_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.NIGHTMARE_DUST_BLOCK);
            event.accept(ModBlocks.ORANGE_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.ORANGE_DUNGEON_BLOCK);
            event.accept(ModBlocks.ORANGE_DUNGEON_PILLAR);
            event.accept(ModBlocks.ORANGE_DUNGEON_STAIRS);
            event.accept(ModBlocks.ORANGE_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.ORANGE_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.ORANGE_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.PINK_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.PINK_DUNGEON_BLOCK);
            event.accept(ModBlocks.PINK_DUNGEON_PILLAR);
            event.accept(ModBlocks.PINK_DUNGEON_STAIRS);
            event.accept(ModBlocks.PINK_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.PINK_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.PINK_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.PURPLE_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.PURPLE_DUNGEON_BLOCK);
            event.accept(ModBlocks.PURPLE_DUNGEON_PILLAR);
            event.accept(ModBlocks.PURPLE_DUNGEON_STAIRS);
            event.accept(ModBlocks.PURPLE_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.PURPLE_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.PURPLE_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.RAW_SILVER_BLOCK);
            event.accept(ModBlocks.RAW_TRANITE_BLOCK);
            event.accept(ModBlocks.RAW_WOLFRAMITE_BLOCK);
            event.accept(ModBlocks.RED_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.RED_DUNGEON_BLOCK);
            event.accept(ModBlocks.RED_DUNGEON_PILLAR);
            event.accept(ModBlocks.RED_DUNGEON_STAIRS);
            event.accept(ModBlocks.RED_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.RED_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.RED_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.RUBBER_BLOCK);
            event.accept(ModBlocks.SCRAPS_BLOCK);
            event.accept(ModBlocks.SILVER_ORE);
            event.accept(ModBlocks.STEEL_BLOCK);
            event.accept(ModBlocks.STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.THERMITE_BLOCK);
            event.accept(ModBlocks.THERMITE_ORE);
            event.accept(ModBlocks.TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.TRANITE_BLOCK);
            event.accept(ModBlocks.TRANITE_ORE);
            event.accept(ModBlocks.TUNGSTEN_BLOCK);
            event.accept(ModBlocks.TUNGSTEN_ORE);
            event.accept(ModBlocks.WASTELAND_COBBLESTONE);
            event.accept(ModBlocks.WASTELAND_STONE);
            event.accept(ModBlocks.WHITE_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.WHITE_DUNGEON_BLOCK);
            event.accept(ModBlocks.WHITE_DUNGEON_PILLAR);
            event.accept(ModBlocks.WHITE_DUNGEON_STAIRS);
            event.accept(ModBlocks.WHITE_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.WHITE_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.WHITE_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.WILLOW_LEAVES);
            event.accept(ModBlocks.WILLOW_PLANKS);
            event.accept(ModBlocks.WILLOW_WOOD);
            event.accept(ModBlocks.WOLFRAMITE_ORE);
            event.accept(ModBlocks.YELLOW_CITY_FLOOR_BLOCK);
            event.accept(ModBlocks.YELLOW_DUNGEON_BLOCK);
            event.accept(ModBlocks.YELLOW_DUNGEON_PILLAR);
            event.accept(ModBlocks.YELLOW_DUNGEON_STAIRS);
            event.accept(ModBlocks.YELLOW_DYED_STEEL_BLOCK);
            event.accept(ModBlocks.YELLOW_STEEL_BORDERED_GLASS);
            event.accept(ModBlocks.YELLOW_TINTED_DUNGEON_GLASS);
            event.accept(ModBlocks.SILVER_BLOCK);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
