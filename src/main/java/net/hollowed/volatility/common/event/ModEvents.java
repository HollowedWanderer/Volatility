package net.hollowed.volatility.common.event;

import net.hollowed.volatility.Volatility;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.hollowed.volatility.Volatility.MOD_ID;

@Mod.EventBusSubscriber(modid = Volatility.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            //if(event.getType() == ModVillagers.SPELUNKER.get()) {
              //  Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
              //  ItemStack stack = new ItemStack(ModItems.STEEL_INGOT.get(), 1);
              //  int villagerLevel = 1;

              //  trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                //        new ItemStack(Items.EMERALD, 5),
                  //      stack,10,8,0.02F));
            //}
        }
    }
    @Mod.EventBusSubscriber(modid = Volatility.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
    }

}
