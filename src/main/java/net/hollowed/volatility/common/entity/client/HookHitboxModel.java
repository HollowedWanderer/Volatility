package net.hollowed.volatility.common.entity.client;

import net.hollowed.volatility.common.entity.entities.HookHitboxEntity;
import net.hollowed.volatility.common.entity.entities.ScratcherEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HookHitboxModel extends GeoModel<HookHitboxEntity> {
    @Override
    public ResourceLocation getAnimationResource(HookHitboxEntity entity) {
        return new ResourceLocation("volatility", "animations/hook.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(HookHitboxEntity entity) {
        return new ResourceLocation("volatility", "geo/hook.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HookHitboxEntity entity) {
        return new ResourceLocation("volatility", "textures/entity/" + entity.getTexture() + ".png");
    }
}

