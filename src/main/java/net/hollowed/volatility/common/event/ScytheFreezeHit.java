package net.hollowed.volatility.common.event;

import net.hollowed.volatility.common.client.shader.GlowPostProcessor;
import net.hollowed.volatility.common.client.shader.LightingFx;
import net.hollowed.volatility.common.effect.ModEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import org.joml.Vector3f;

public class ScytheFreezeHit {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(ModEffects.SCYTHE_FROZEN.get(), 100, 0, false, true));
    }
}

