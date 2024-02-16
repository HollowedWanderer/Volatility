package net.hollowed.volatility.common.block.model;

import net.hollowed.volatility.common.block.display.DungeonDoorOpenDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class DungeonDoorOpenDisplayModel extends GeoModel<DungeonDoorOpenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DungeonDoorOpenDisplayItem animatable) {
		return new ResourceLocation("volatility", "animations/dungeon_door_open.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DungeonDoorOpenDisplayItem animatable) {
		return new ResourceLocation("volatility", "geo/dungeon_door_open.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DungeonDoorOpenDisplayItem entity) {
		return new ResourceLocation("volatility", "textures/block/dungeon_door.png");
	}
}
