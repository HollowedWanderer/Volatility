package net.hollowed.volatility;

import com.mojang.logging.LogUtils;
import net.hollowed.volatility.common.block.BlockRegistry;
import net.hollowed.volatility.common.block.ItemRegistry;
import net.hollowed.volatility.common.block.ModBlocks;
import net.hollowed.volatility.common.block.entity.ModBlockEntities;
//import net.hollowed.volatility.common.client.particle.ModParticleTypes;
//import net.hollowed.volatility.common.client.particle.ModParticles;
import net.hollowed.volatility.common.client.particle.ModParticleTypes;
import net.hollowed.volatility.common.effect.ModEffects;
import net.hollowed.volatility.common.enchantment.ModEnchantments;
import net.hollowed.volatility.common.entity.ModEntityTypes;
import net.hollowed.volatility.common.event.ModClientSetupEvents;
import net.hollowed.volatility.common.event.ModCommonSetupEvents;
import net.hollowed.volatility.common.item.ModCreativeModeTab;
import net.hollowed.volatility.common.item.ModItems;
import net.hollowed.volatility.common.sound.ModSounds;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Volatility.MOD_ID)
public class Volatility {
    public static final String MOD_ID = "volatility";
    public static final Logger LOGGER = LogUtils.getLogger();

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MOD_ID, MOD_ID), () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static int messageID = 0;

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() == 0)
                    actions.add(work);
            });
            actions.forEach(e -> e.getKey().run());
            workQueue.removeAll(actions);
        }
    }






    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();




    public Volatility() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModParticleTypes.REGISTRY.register(modEventBus);
        ModCreativeModeTab.register(modEventBus);
        //ModParticleTypes.REGISTRY.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        BlockRegistry.register(modEventBus);
        ItemRegistry.register(modEventBus);

        //ModEnchantments.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntityTypes.REGISTRY.register(modEventBus);
        //ModEntityTypes.register(modEventBus);
       // ModVillagers.register(modEventBus);
        //ModRecipes.register(modEventBus);

        GeckoLib.initialize();

        ModEnchantments.REGISTRY.register(modEventBus);


        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onClientSetup);
        //modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onClientSetup(final FMLClientSetupEvent event) {
        // Some client setup code
        LOGGER.info("Starting Client Setup...");

        ModClientSetupEvents.modWoodTypes();
        ModClientSetupEvents.modRenderTypes();

        LOGGER.info("Client Setup finished.");
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("Starting Common Setup...");

        ModCommonSetupEvents.addModWoodTypes(event);
        //ModCommonSetupEvents.addModItemProperties(event);
        ModCommonSetupEvents.addModVillagerPOIS(event);

        LOGGER.info("Common Setup finished.");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == ModCreativeModeTab.EQUIPMENT_TAB.get()) {
            event.accept(ModItems.ROCK);
            event.accept(ModItems.PLANT_FIBER);
            event.accept(ModItems.SHARP_STICK);
            event.accept(ModItems.SHARP_BONE);
            event.accept(ModItems.SHARP_ROCK);
            event.accept(ModItems.FLINT_SHARD);
            event.accept(ModItems.FLINT_KNIFE);
            event.accept(ModItems.TWINE);
            event.accept(ModItems.ELK_ANTLER);
            event.accept(ModItems.BOSS_ANTLER);
            event.accept(ModItems.TATTERED_LINEN);
            //event.accept(ModItems.DUSTED_CLOTH);
            event.accept(ModItems.STONE_AXE);
            event.accept(ModItems.ANTLER_PICKAXE);
            event.accept(ModItems.STEEL_SCRAP);
            event.accept(ModItems.SILVER_SCRAP);
            event.accept(ModItems.PLATINUM);
            event.accept(ModItems.COAL_DUST);
            event.accept(ModItems.IRON_PLATE);
            event.accept(ModItems.STEEL_PLATE);
            event.accept(ModItems.SILVER_PLATE);
            event.accept(ModItems.GOLD_PLATE);
            event.accept(ModItems.PLATINUM_PLATE);
            event.accept(ModBlocks.MOLTEN_IRON_SCRAP);
            event.accept(ModBlocks.MOLTEN_SILVER_SCRAP);
            event.accept(ModBlocks.MOLTEN_STEEL_SCRAP);
            event.accept(ModBlocks.MOLTEN_GOLD_SCRAP);
            event.accept(ModBlocks.MOLTEN_PLATINUM_SCRAP);
            event.accept(ModItems.BONE_SCYTHE);
            event.accept(ModItems.CRYONIC_SCYTHE);
            event.accept(ModItems.ILLAGER_KNIGHTS_GREATSWORD);
            event.accept(ModItems.GREAT_HAMMER);
            event.accept(ModItems.SMITHING_HAMMER);
            event.accept(ModItems.DEATHS_SCYTHE);
            event.accept(ModItems.STEEL_SWORD);
            event.accept(ModItems.STEEL_PICKAXE);
            event.accept(ModItems.STEEL_AXE);
            event.accept(ModItems.STEEL_SHOVEL);
            event.accept(ModItems.STEEL_HOE);
            event.accept(ModItems.STEEL_HELMET);
            event.accept(ModItems.STEEL_CHESTPLATE);
            event.accept(ModItems.STEEL_LEGGING);
            event.accept(ModItems.STEEL_BOOTS);
            event.accept(ModItems.STEEL_GREATSWORD);
            event.accept(ModItems.STEEL_GLAIVE);
            event.accept(ModItems.PLATINUM_SWORD);
            event.accept(ModItems.PLATINUM_PICKAXE);
            event.accept(ModItems.PLATINUM_AXE);
            event.accept(ModItems.PLATINUM_SHOVEL);
            event.accept(ModItems.PLATINUM_HOE);
            event.accept(ModItems.PLATINUM_HELMET);
            event.accept(ModItems.PLATINUM_CHESTPLATE);
            event.accept(ModItems.PLATINUM_LEGGINGS);
            event.accept(ModItems.PLATINUM_BOOTS);
            event.accept(ModItems.PLATINUM_GREATSWORD);
            event.accept(ModItems.PLATINUM_GLAIVE);
            event.accept(ModItems.SILVER_HELMET);
            event.accept(ModItems.SILVER_PLATED_CHESTPIECE);
            event.accept(ModItems.SILVER_PLATED_LEGGINGS);
            event.accept(ModItems.SILVER_TIPPED_BOOTS);
            event.accept(ModItems.SILVER_PLATED_CROSSBOW);
            event.accept(ModItems.WOODEN_GLAIVE);
            event.accept(ModItems.STONE_GLAIVE);
            event.accept(ModItems.IRON_GLAIVE);
            event.accept(ModItems.GOLDEN_GLAIVE);
            event.accept(ModItems.DIAMOND_GLAIVE);
            event.accept(ModItems.NETHERITE_GLAIVE);
            event.accept(ModItems.WOODEN_GREATSWORD);
            event.accept(ModItems.STONE_GREATSWORD);
            event.accept(ModItems.IRON_GREATSWORD);
            event.accept(ModItems.GOLDEN_GREATSWORD);
            event.accept(ModItems.DIAMOND_GREATSWORD);
            event.accept(ModItems.NETHERITE_GREATSWORD);
            event.accept(ModItems.VANGUARD_SHIELD);
            event.accept(ModItems.HORNED_DIAMOND_HELMET);
            event.accept(ModItems.CRAB_CLAW);
        }
        if(event.getTab() == ModCreativeModeTab.SORCERY_TAB.get()) {
            event.accept(ModItems.ETERNAL_GOLDEN_CARROT);
            event.accept(ModItems.STAFF_OF_THUNDERING);
            event.accept(ModItems.ICE_WAND);
            event.accept(ModItems.VIRIDIS_BLADE);
            event.accept(ModItems.EXPERIENCE_JAR);
        }
        if(event.getTab() == ModCreativeModeTab.BLOCKS_TAB.get()) {
            event.accept(ModBlocks.PLATINUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_PLATINUM_ORE);
            event.accept(ModBlocks.DUNGEON_STEEL);
            event.accept(ModBlocks.ENGRAVED_DUNGEON_STEEL);
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.INFERNIUM_BLOCK);
            event.accept(ModBlocks.ZEPHYRITE_BLOCK);
            event.accept(ModBlocks.STEEL_BLOCK);
            event.accept(ModBlocks.MYTHRIL_BLOCK);
            event.accept(ModBlocks.PLATINUM_BLOCK);
            event.accept(ModBlocks.STICK_BUNDLE);
            event.accept(ModBlocks.SLATE);
            event.accept(ModBlocks.SLATE_BRICKS);
            event.accept(ModBlocks.SLATE_TILES);
            //event.accept(ModBlocks.SLATE_BRICK_STAIRS);
            //event.accept(ModBlocks.SLATE_BRICK_SLAB);
            //event.accept(ModBlocks.SLATE_BRICK_WALL);
            //event.accept(ModBlocks.SLATE_TILE_SLAB);
            //event.accept(ModBlocks.SLATE_TILE_STAIRS);
            event.accept(ModBlocks.ANCIENT_CLAY);
            event.accept(ModBlocks.ANCIENT_CLAY_STAIRS);
            event.accept(ModBlocks.ANCIENT_CLAY_SLAB);
            event.accept(ModBlocks.ANCIENT_CLAY_BRICKS);
            event.accept(ModBlocks.ANCIENT_CLAY_BRICK_STAIRS);
            event.accept(ModBlocks.ANCIENT_CLAY_BRICK_SLAB);
            event.accept(ModBlocks.ANCIENT_CLAY_BRICK_WALL);
            event.accept(ModBlocks.TRIMMED_ANCIENT_CLAY);
            event.accept(ModBlocks.ANCIENT_URN);
            event.accept(ModBlocks.SNOW_RIMMED_POLISHED_ANDESITE);
            event.accept(ModBlocks.SNOW_COVERED_POLISHED_ANDESITE);
            event.accept(ModBlocks.FROSTED_STONE_BRICKS);
            event.accept(ModBlocks.VERTICAL_DARK_OAK_PLANKS);
            event.accept(ModBlocks.BROWN_TERRACOTTA_SHINGLES);
            event.accept(ModBlocks.DUNGEON_DOOR);
            event.accept(ModBlocks.ENCHANTER_STATUE);
            event.accept(ModBlocks.SNOWY_ENCHANTER_STATUE);
            event.accept(ModBlocks.SUSPICIOUS_DIRT);
            event.accept(ItemRegistry.PEDESTAL_ITEM);
            event.accept(ModBlocks.AQUARIUM_GLASS);
        }
        //if(event.getTab() == ModCreativeModeTab.ENTITIES_TAB.get()) {
        //    event.accept(ModItems.ICEOLOGER_SPAWN_EGG);
        //}
    }

  //  private void enqueueIMC(final InterModEnqueueEvent event) {
   //     SlotTypePreset[] types = {SlotTypePreset.HEAD, SlotTypePreset.NECKLACE, SlotTypePreset.BELT, SlotTypePreset.BACK};
   //     for (SlotTypePreset type : types) {
   //         InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> type.getMessageBuilder().build());
   //     }

   //     InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
    //            () -> SlotTypePreset.HANDS.getMessageBuilder().size(2).build());
    //    InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
    //            () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
    //    InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
    //            () -> new SlotTypeMessage.Builder("feet")
     //                   .priority(220).icon(InventoryMenu.EMPTY_ARMOR_SLOT_BOOTS).build());
   // }

   public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder,
                                             Function<FriendlyByteBuf, T> decoder,
                                             BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

}
