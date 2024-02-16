package net.hollowed.volatility.common.block.renderer;

import net.hollowed.volatility.common.block.display.DungeonDoorOpenDisplayItem;
import net.hollowed.volatility.common.block.model.DungeonDoorOpenDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;


public class DungeonDoorOpenDisplayItemRenderer extends GeoItemRenderer<DungeonDoorOpenDisplayItem> {
	public DungeonDoorOpenDisplayItemRenderer() {
		super(new DungeonDoorOpenDisplayModel());
	}

	@Override
	public RenderType getRenderType(DungeonDoorOpenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
