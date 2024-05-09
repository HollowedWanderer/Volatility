package net.hollowed.volatility.common.entity.client;

import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.hollowed.volatility.common.entity.entities.SkeletonNecromancerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SkeletonNecromancerModel extends GeoModel<SkeletonNecromancerEntity> {
    @Override
    public ResourceLocation getAnimationResource(SkeletonNecromancerEntity entity) {
        return new ResourceLocation("volatility", "animations/skeleton_necromancer.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SkeletonNecromancerEntity entity) {
        return new ResourceLocation("volatility", "geo/skeleton_necromancer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SkeletonNecromancerEntity entity) {
        return new ResourceLocation("volatility", "textures/entity/skeleton_necromancer.png");
    }

    @Override
    public void setCustomAnimations(SkeletonNecromancerEntity animatable, long instanceId, AnimationState animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }

    }
}

