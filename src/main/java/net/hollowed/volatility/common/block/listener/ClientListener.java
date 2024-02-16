package net.hollowed.volatility.common.block.listener;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.block.entity.ModBlockEntities;
import net.hollowed.volatility.common.block.renderer.DungeonDoorOpenTileRenderer;
import net.hollowed.volatility.common.block.renderer.DungeonDoorTileRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Volatility.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntities.DUNGEON_DOOR.get(), context -> new DungeonDoorTileRenderer());
		event.registerBlockEntityRenderer(ModBlockEntities.DUNGEON_DOOR_OPEN.get(), context -> new DungeonDoorOpenTileRenderer());
	}
}
