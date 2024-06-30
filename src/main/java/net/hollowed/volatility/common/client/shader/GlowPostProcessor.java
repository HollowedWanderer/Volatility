package net.hollowed.volatility.common.client.shader;

import com.mojang.blaze3d.vertex.PoseStack;
import net.hollowed.volatility.Volatility;
import team.lodestar.lodestone.systems.postprocess.MultiInstancePostProcessor;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.PostChain;

import java.io.IOException;

public class GlowPostProcessor extends MultiInstancePostProcessor<LightingFx> {
    public static final GlowPostProcessor INSTANCE = new GlowPostProcessor();
    private EffectInstance effectGlow;

    @Override
    public ResourceLocation getPostChainLocation() {
        return new ResourceLocation(Volatility.MOD_ID, "shaders/post/glow_post");
    }

    @Override
    protected int getMaxInstances() {
        return 32767;
    }

    @Override
    protected int getDataSizePerInstance() {
        return 6;
    }

    @Override
    public void init() {
        super.init();
        if (postChain != null) {
            if (effects != null && effects.length > 0) {
                effectGlow = effects[0];
            } else {
                System.err.println("Effects array is null or empty.");
            }
        } else {
            System.err.println("PostChain is null.");
        }
    }

    @Override
    public void beforeProcess(PoseStack viewModelStack) {
        super.beforeProcess(viewModelStack);
        if (effectGlow != null) {
            setDataBufferUniform(effectGlow, "DataBuffer", "InstanceCount");
        } else {
            System.err.println("EffectGlow is null.");
        }
    }

    @Override
    public void afterProcess() {

    }
}
