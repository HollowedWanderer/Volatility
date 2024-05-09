package net.hollowed.volatility.common.block.renderer;

import net.hollowed.volatility.common.block.display.ArmorPileDisplayItem;
import net.hollowed.volatility.common.block.model.ArmorPileDisplayModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;


public class ArmorPileDisplayItemRenderer extends GeoItemRenderer<ArmorPileDisplayItem> {
    public ArmorPileDisplayItemRenderer() {
        super(new ArmorPileDisplayModel());
    }

    @Override
    public RenderType getRenderType(ArmorPileDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}

