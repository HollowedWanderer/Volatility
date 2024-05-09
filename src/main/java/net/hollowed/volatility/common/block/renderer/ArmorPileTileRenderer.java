package net.hollowed.volatility.common.block.renderer;

import net.hollowed.volatility.common.block.entity.custom.ArmorPileTileEntity;
import net.hollowed.volatility.common.block.model.ArmorPileBlockModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class ArmorPileTileRenderer extends GeoBlockRenderer<ArmorPileTileEntity> {
    public ArmorPileTileRenderer() {
        super(new ArmorPileBlockModel());
    }

    @Override
    public RenderType getRenderType(ArmorPileTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}

