package net.hollowed.volatility.common.item;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Volatility.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            Volatility.MOD_ID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
    public static RegistryObject<CreativeModeTab> EQUIPMENT_TAB = CREATIVE_MODE_TABS.register("equipment_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL_SWORD.get())).title(Component.literal("Equipment/Ingredients")).build());
    public static RegistryObject<CreativeModeTab> SORCERY_TAB = CREATIVE_MODE_TABS.register("sorcery_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STAFF_OF_THUNDERING.get())).title(Component.literal("Magic")).build());
    public static RegistryObject<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TABS.register("blocks_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SLATE.get())).title(Component.literal("Blocks")).build());

    //public static RegistryObject<CreativeModeTab> ENTITIES_TAB = CREATIVE_MODE_TABS.register("entities_tab", () ->
      //      CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ICEOLOGER_SPAWN_EGG.get())).title(Component.literal("volatility - Creatures/Monsters")).build());
}
