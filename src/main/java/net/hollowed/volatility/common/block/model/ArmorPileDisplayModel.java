package net.hollowed.volatility.common.block.model;

import net.hollowed.volatility.common.block.display.ArmorPileDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArmorPileDisplayModel extends GeoModel<ArmorPileDisplayItem> {
    @Override
    public ResourceLocation getAnimationResource(ArmorPileDisplayItem animatable) {
        return new ResourceLocation("volatility", "animations/armor_pile.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(ArmorPileDisplayItem animatable) {
        return new ResourceLocation("volatility", "geo/armor_pile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArmorPileDisplayItem entity) {
        return new ResourceLocation("volatility", "textures/block/cursed_remains.png");
    }
}

