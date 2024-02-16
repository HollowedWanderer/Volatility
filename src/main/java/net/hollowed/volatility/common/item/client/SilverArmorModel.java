package net.hollowed.volatility.common.item.client;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.item.custom.SilverArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SilverArmorModel extends GeoModel<SilverArmorItem> {
    @Override
    public ResourceLocation getModelResource(SilverArmorItem animatable) {
        return new ResourceLocation(Volatility.MOD_ID, "geo/silver_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SilverArmorItem animatable) {
        return new ResourceLocation(Volatility.MOD_ID, "textures/armor/silver_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SilverArmorItem animatable) {
        return new ResourceLocation(Volatility.MOD_ID, "animations/silver_armor.animation.json");
    }
}
