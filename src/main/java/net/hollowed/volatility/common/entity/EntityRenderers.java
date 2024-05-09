package net.hollowed.volatility.common.entity;

import net.hollowed.volatility.common.entity.client.*;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.CURSED_REMAINS.get(), CursedRemainsRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.SCRATCHER.get(), ScratcherRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.GRAPPLING_HOOK.get(), RemnantHookRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.HOOK_HITBOX.get(), HookHitboxRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.SKELETON_NECROMANCER.get(), SkeletonNecromancerRenderer::new);

    }
}
