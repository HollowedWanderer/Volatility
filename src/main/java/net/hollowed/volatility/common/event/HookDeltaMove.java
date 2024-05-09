package net.hollowed.volatility.common.event;

import net.hollowed.volatility.common.effect.ModEffects;
import net.hollowed.volatility.common.item.ModItems;
import net.hollowed.volatility.common.network.ModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HookDeltaMove {
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        execute(event, event.getEntity());
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }
    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        if ((entity instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(ModItems.GRAPPLING_HOOK.get())))) {
            LivingEntity _livEnt1 = (LivingEntity) entity;
            if (_livEnt1.hasEffect(ModEffects.HOOKED.get())) {
                Vec3 playerVariables = new Vec3(((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ModVariables.PlayerVariables())).hookX) * 0.8,
                        ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ModVariables.PlayerVariables())).hookY * 0.6),
                        ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ModVariables.PlayerVariables())).hookZ) * 0.8);

                Vec3 currentDeltaMovement = entity.getDeltaMovement();

                // Add the hook variables to the current delta movement
                Vec3 newDeltaMovement = currentDeltaMovement.add(playerVariables);

                // Set the modified delta movement
                entity.setDeltaMovement(newDeltaMovement);
                if (entity.fallDistance > 4) {
                    entity.fallDistance = 4;
                }
            }
        } else {
            {
                Scoreboard _sc = entity.level().getScoreboard();
                Objective _so = _sc.getObjective("killHook");
                if (_so == null)
                    _so = _sc.addObjective("killHook", ObjectiveCriteria.DUMMY, Component.literal("killHook"), ObjectiveCriteria.RenderType.INTEGER);
                _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(1);
            }
        }
    }
}

