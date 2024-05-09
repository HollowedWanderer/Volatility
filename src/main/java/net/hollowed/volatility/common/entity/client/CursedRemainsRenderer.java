package net.hollowed.volatility.common.entity.client;

import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.hollowed.volatility.common.entity.layer.CursedRemainsLayer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;


import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CursedRemainsRenderer extends GeoEntityRenderer<CursedRemainsEntity> {
    public CursedRemainsRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CursedRemainsModel());
        this.shadowRadius = 0.8f;
        this.addRenderLayer(new CursedRemainsLayer(this));
    }

    @Override
    public RenderType getRenderType(CursedRemainsEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, CursedRemainsEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 1.1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected float getDeathMaxRotation(CursedRemainsEntity entityLivingBaseIn) {
        return 0.0F;
    }
}

