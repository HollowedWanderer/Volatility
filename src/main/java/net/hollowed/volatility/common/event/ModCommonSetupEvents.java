package net.hollowed.volatility.common.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.hollowed.volatility.Volatility.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonSetupEvents {

	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {


		}
	}

	public static void addModWoodTypes (FMLCommonSetupEvent event) {

		event.enqueueWork(() -> {

			//Sheets.addWoodType(ModWoodTypes.MAHOGANY);
			//Sheets.addWoodType(ModWoodTypes.CINNAMON);

		});
	}

	//public static void addModItemProperties (FMLCommonSetupEvent event) {
//
//		event.enqueueWork(() -> {
//
//			@SuppressWarnings("deprecation") ItemPropertyFunction itemPropertyGetter =
//					(stack, world, entity, i) -> entity instanceof Player && ParagliderItem.isItemParagliding(stack) ? 1 : 0;
//
//			ItemProperties.register(ModItems.WINGED_MEDALLION.get(), new ResourceLocation("paragliding"), itemPropertyGetter);
//
//		});
//	}

	public static void addModVillagerPOIS (FMLCommonSetupEvent event) {

		//event.enqueueWork(ModVillagers::registerPOIs);

	}

}
