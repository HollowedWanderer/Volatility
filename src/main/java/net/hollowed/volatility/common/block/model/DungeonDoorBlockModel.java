package net.hollowed.volatility.common.block.model;

import net.hollowed.volatility.common.block.entity.custom.DungeonDoorBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DungeonDoorBlockModel extends GeoModel<DungeonDoorBlockEntity> {
	@Override
	public ResourceLocation getAnimationResource(DungeonDoorBlockEntity animatable) {
		return new ResourceLocation("volatility", "animations/dungeon_door.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DungeonDoorBlockEntity animatable) {
		return new ResourceLocation("volatility", "geo/dungeon_door.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DungeonDoorBlockEntity entity) {
		return new ResourceLocation("volatility", "textures/block/dungeon_door.png");
	}
}
