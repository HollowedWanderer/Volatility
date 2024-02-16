package net.hollowed.volatility.common.block.renderer;

import net.hollowed.volatility.common.block.entity.custom.DungeonDoorBlockEntity;
import net.hollowed.volatility.common.block.model.DungeonDoorBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;


public class DungeonDoorTileRenderer extends GeoBlockRenderer<DungeonDoorBlockEntity> {
	public DungeonDoorTileRenderer() {
		super(new DungeonDoorBlockModel());
	}

	@Override
	public RenderType getRenderType(DungeonDoorBlockEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
