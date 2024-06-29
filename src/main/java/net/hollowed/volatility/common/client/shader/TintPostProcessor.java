package net.hollowed.volatility.common.client.shader;

import com.mojang.blaze3d.vertex.PoseStack;
import net.hollowed.volatility.Volatility;
import net.minecraft.resources.ResourceLocation;
import team.lodestar.lodestone.systems.postprocess.PostProcessor;

public class TintPostProcessor extends PostProcessor {
    public static final TintPostProcessor INSTANCE = new TintPostProcessor();

    static {
        INSTANCE.setActive(true);
    }

    @Override
    public ResourceLocation getPostChainLocation() {
        return new ResourceLocation(Volatility.MOD_ID, "tint_post");
    }

    @Override
    public void beforeProcess(PoseStack poseStack) {

    }

    @Override
    public void afterProcess() {

    }
}
