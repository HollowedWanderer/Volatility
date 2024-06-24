package net.hollowed.volatility.common.entity.layer;

import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class CursedRemainsLayer extends GeoRenderLayer<CursedRemainsEntity> {
    private static final ResourceLocation LAYER = new ResourceLocation("volatility", "textures/entity/cursed_remains_e.png");
    private static final ResourceLocation LAYER2 = new ResourceLocation("volatility", "textures/entity/cursed_remains_e_2.png");

    public CursedRemainsLayer(GeoRenderer<CursedRemainsEntity> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(PoseStack poseStack, CursedRemainsEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType glowRenderType = RenderType.eyes(LAYER);
        RenderType glowRenderType2 = RenderType.eyes(LAYER2);
        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType2, bufferSource.getBuffer(glowRenderType2), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
    }
}

