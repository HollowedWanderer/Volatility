package net.hollowed.volatility.common.block.model;

import net.hollowed.volatility.common.block.entity.custom.ArmorPileTileEntity;
import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class ArmorPileBlockModel extends GeoModel<ArmorPileTileEntity> {
    @Override
    public ResourceLocation getAnimationResource(ArmorPileTileEntity animatable) {
        return new ResourceLocation("volatility", "animations/armor_pile.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(ArmorPileTileEntity animatable) {
        return new ResourceLocation("volatility", "geo/armor_pile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArmorPileTileEntity entity) {
        return new ResourceLocation("volatility", "textures/block/cursed_remains.png");
    }
}

