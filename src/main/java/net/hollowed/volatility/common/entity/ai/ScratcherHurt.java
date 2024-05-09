package net.hollowed.volatility.common.entity.ai;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.entity.entities.ScratcherEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.Objects;

public class ScratcherHurt {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        Volatility.queueServerWork(4, ()-> {
            if (entity instanceof ScratcherEntity animatable)
                animatable.setTexture("scratcher_ball");
        });
        if (entity instanceof ScratcherEntity && entity.getPersistentData().getDouble("hurtCooldown") <= 0) {
            ((ScratcherEntity) entity).setAnimation("ball");
        }
        entity.getPersistentData().putDouble("hurtCooldown", 110);
        Volatility.queueServerWork(1, ()-> {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 130, 255, false, false));
                    }
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 130, 4, false, false));
                    }
                });
        Volatility.queueServerWork(110, () -> {
            if (entity.getPersistentData().getDouble("hurtCooldown") <= 0) {
                assert entity instanceof ScratcherEntity;
                ((ScratcherEntity) entity).setAnimation("unball");
                Volatility.queueServerWork(15, () -> {
                    ScratcherEntity animatable = (ScratcherEntity) entity;
                    animatable.setTexture("scratcher");
                    if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                                entity.getName().getString(), entity.getDisplayName(), Objects.requireNonNull(entity.level().getServer()), entity), "data merge entity @s {NoAI:0b}");
                    }
                });
            }
        });
    }
}



