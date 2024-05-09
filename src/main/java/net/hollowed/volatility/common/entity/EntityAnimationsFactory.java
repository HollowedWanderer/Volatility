package net.hollowed.volatility.common.entity;

import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.hollowed.volatility.common.entity.entities.HookHitboxEntity;
import net.hollowed.volatility.common.entity.entities.ScratcherEntity;
import net.hollowed.volatility.common.entity.entities.SkeletonNecromancerEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

@Mod.EventBusSubscriber
public class EntityAnimationsFactory {
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        if (event != null && event.getEntity() != null) {
            if (event.getEntity() instanceof CursedRemainsEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof ScratcherEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof HookHitboxEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SkeletonNecromancerEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
        }
    }
}

