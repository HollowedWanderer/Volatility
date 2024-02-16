package net.hollowed.volatility.common.item.client;

import net.hollowed.volatility.common.item.custom.SteelArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SteelArmorRenderer extends GeoArmorRenderer<SteelArmorItem> {
    public SteelArmorRenderer() {
        super(new SteelArmorModel());
    }
}
