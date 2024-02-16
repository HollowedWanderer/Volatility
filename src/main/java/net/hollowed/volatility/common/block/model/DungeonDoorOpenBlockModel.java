package net.hollowed.volatility.common.block.model;

import net.hollowed.volatility.common.block.entity.custom.DungeonDoorOpenBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class DungeonDoorOpenBlockModel extends GeoModel<DungeonDoorOpenBlockEntity> {
	@Override
	public ResourceLocation getAnimationResource(DungeonDoorOpenBlockEntity animatable) {
		return new ResourceLocation("volatility", "animations/dungeon_door_open.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DungeonDoorOpenBlockEntity animatable) {
		return new ResourceLocation("volatility", "geo/dungeon_door_open.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DungeonDoorOpenBlockEntity entity) {
		return new ResourceLocation("volatility", "textures/block/dungeon_door.png");
	}
}
