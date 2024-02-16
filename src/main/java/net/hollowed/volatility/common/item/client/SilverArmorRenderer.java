package net.hollowed.volatility.common.item.client;

import net.hollowed.volatility.common.item.custom.SilverArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SilverArmorRenderer extends GeoArmorRenderer<SilverArmorItem> {
    public SilverArmorRenderer() {
        super(new SilverArmorModel());
    }
}
