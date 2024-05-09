package net.hollowed.volatility.common.entity.client;

import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

public class CursedRemainsModel extends GeoModel<CursedRemainsEntity> {
    @Override
    public ResourceLocation getAnimationResource(CursedRemainsEntity entity) {
        return new ResourceLocation("volatility", "animations/cursed_remains.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(CursedRemainsEntity entity) {
        return new ResourceLocation("volatility", "geo/cursed_remains.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CursedRemainsEntity entity) {
        return new ResourceLocation("volatility", "textures/entity/cursed_remains.png");
    }

    @Override
    public void setCustomAnimations(CursedRemainsEntity animatable, long instanceId, AnimationState animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }

    }
}

