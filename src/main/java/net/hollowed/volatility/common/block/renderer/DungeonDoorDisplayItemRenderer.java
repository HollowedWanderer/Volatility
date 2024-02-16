package net.hollowed.volatility.common.block.renderer;

import net.hollowed.volatility.common.block.display.DungeonDoorDisplayItem;
import net.hollowed.volatility.common.block.model.DungeonDoorDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;


public class DungeonDoorDisplayItemRenderer extends GeoItemRenderer<DungeonDoorDisplayItem> {
	public DungeonDoorDisplayItemRenderer() {
		super(new DungeonDoorDisplayModel());
	}

	@Override
	public RenderType getRenderType(DungeonDoorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
