package net.hollowed.volatility.common.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.hollowed.volatility.common.client.shader.GlowPostProcessor;
import net.hollowed.volatility.common.client.shader.TintPostProcessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import team.lodestar.lodestone.systems.postprocess.PostProcessHandler;

import static net.hollowed.volatility.Volatility.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        PostProcessHandler.addInstance(TintPostProcessor.INSTANCE);
        PostProcessHandler.addInstance(GlowPostProcessor.INSTANCE);
    }
}
