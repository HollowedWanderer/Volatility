package net.hollowed.volatility.common.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hollowed.volatility.common.entity.entities.HookHitboxEntity;
import net.hollowed.volatility.common.entity.entities.ScratcherEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HookHitboxRenderer extends GeoEntityRenderer<HookHitboxEntity> {
    public HookHitboxRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HookHitboxModel());
        this.shadowRadius = 0.0f;
    }

    @Override
    public RenderType getRenderType(HookHitboxEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, HookHitboxEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected float getDeathMaxRotation(HookHitboxEntity entityLivingBaseIn) {
        return 0.0F;
    }
}

