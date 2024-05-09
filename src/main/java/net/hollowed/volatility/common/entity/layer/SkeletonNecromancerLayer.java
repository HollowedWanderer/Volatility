package net.hollowed.volatility.common.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.hollowed.volatility.common.entity.entities.SkeletonNecromancerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SkeletonNecromancerLayer extends GeoRenderLayer<SkeletonNecromancerEntity> {
    private static final ResourceLocation LAYER = new ResourceLocation("volatility", "textures/entity/skeleton_necromancer_e.png");
    private static final ResourceLocation LAYER2 = new ResourceLocation("volatility", "textures/entity/skeleton_necromancer_e_staff.png");

    private static final ResourceLocation LAYER3 = new ResourceLocation("volatility", "textures/entity/skeleton_necromancer_e_2.png");

    public SkeletonNecromancerLayer(GeoRenderer<SkeletonNecromancerEntity> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(PoseStack poseStack, SkeletonNecromancerEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType glowRenderType = RenderType.eyes(LAYER);
        RenderType glowRenderType2 = RenderType.eyes(LAYER2);
        RenderType glowRenderType3 = RenderType.eyes(LAYER3);
        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType2, bufferSource.getBuffer(glowRenderType2), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType3, bufferSource.getBuffer(glowRenderType3), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
    }
}

