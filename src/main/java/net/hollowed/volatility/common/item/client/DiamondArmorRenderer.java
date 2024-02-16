package net.hollowed.volatility.common.item.client;

import net.hollowed.volatility.common.item.custom.DiamondArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DiamondArmorRenderer extends GeoArmorRenderer<DiamondArmorItem> {
    public DiamondArmorRenderer() {
        super(new DiamondArmorModel());
    }
}
