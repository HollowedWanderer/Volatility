package net.hollowed.volatility.common.block.renderer;

import net.hollowed.volatility.common.block.entity.custom.DungeonDoorOpenBlockEntity;
import net.hollowed.volatility.common.block.model.DungeonDoorOpenBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DungeonDoorOpenTileRenderer extends GeoBlockRenderer<DungeonDoorOpenBlockEntity> {
	public DungeonDoorOpenTileRenderer() {
		super(new DungeonDoorOpenBlockModel());
	}

	@Override
	public RenderType getRenderType(DungeonDoorOpenBlockEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
