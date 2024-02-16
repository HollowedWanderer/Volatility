package net.hollowed.volatility.common.item.client;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.item.custom.DiamondArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DiamondArmorModel extends GeoModel<DiamondArmorItem> {
    @Override
    public ResourceLocation getModelResource(DiamondArmorItem animatable) {
        return new ResourceLocation(Volatility.MOD_ID, "geo/horned_diamond_helmet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DiamondArmorItem animatable) {
        return new ResourceLocation(Volatility.MOD_ID, "textures/armor/horned_diamond_helmet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DiamondArmorItem animatable) {
        return new ResourceLocation(Volatility.MOD_ID, "animations/horned_diamond_helmet.animation.json");
    }
}
