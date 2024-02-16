package net.hollowed.volatility.common.block.model;

import net.hollowed.volatility.common.block.display.DungeonDoorDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class DungeonDoorDisplayModel extends GeoModel<DungeonDoorDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DungeonDoorDisplayItem animatable) {
		return new ResourceLocation("volatility", "animations/dungeon_door.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DungeonDoorDisplayItem animatable) {
		return new ResourceLocation("volatility", "geo/dungeon_door.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DungeonDoorDisplayItem entity) {
		return new ResourceLocation("volatility", "textures/block/dungeon_door.png");
	}
}
