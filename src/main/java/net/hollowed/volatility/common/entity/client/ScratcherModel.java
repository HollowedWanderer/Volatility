package net.hollowed.volatility.common.entity.client;

import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.hollowed.volatility.common.entity.entities.ScratcherEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ScratcherModel extends GeoModel<ScratcherEntity> {
    @Override
    public ResourceLocation getAnimationResource(ScratcherEntity entity) {
        return new ResourceLocation("volatility", "animations/scratcher.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(ScratcherEntity entity) {
        return new ResourceLocation("volatility", "geo/scratcher.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScratcherEntity entity) {
        return new ResourceLocation("volatility", "textures/entity/" + entity.getTexture() + ".png");
    }
}

