package net.hollowed.volatility.common.event;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.effect.ModEffects;
import net.hollowed.volatility.common.entity.ModEntityTypes;
import net.hollowed.volatility.common.entity.entities.Hook;
import net.hollowed.volatility.common.item.ModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class HookClicked {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;

        if (new Object() {
            public int getScore(String score, Entity _ent) {
                Scoreboard _sc = _ent.level().getScoreboard();
                Objective _so = _sc.getObjective(score);
                if (_so != null)
                    return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
                return 0;
            }
        }.getScore("hookCooldown", entity) == 1) {
            {
                Scoreboard _sc = entity.level().getScoreboard();
                Objective _so = _sc.getObjective("hookCooldown");
                if (_so == null)
                    _so = _sc.addObjective("hookCooldown", ObjectiveCriteria.DUMMY, Component.literal("hookCooldown"), ObjectiveCriteria.RenderType.INTEGER);
                _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(0);
            }
            {
                Scoreboard _sc = entity.level().getScoreboard();
                Objective _so = _sc.getObjective("killHook");
                if (_so == null)
                    _so = _sc.addObjective("killHook", ObjectiveCriteria.DUMMY, Component.literal("killHook"), ObjectiveCriteria.RenderType.INTEGER);
                _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(1);
            }
            Volatility.queueServerWork(2, () -> {
                {
                    Scoreboard _sc = entity.level().getScoreboard();
                    Objective _so = _sc.getObjective("killHook");
                    if (_so == null)
                        _so = _sc.addObjective("killHook", ObjectiveCriteria.DUMMY, Component.literal("killHook"), ObjectiveCriteria.RenderType.INTEGER);
                    _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(0);
                }
            });
            if (entity instanceof Player _player)
                _player.getCooldowns().addCooldown(itemstack.getItem(), 3);
        } else {
            if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).value().getBaseTemperature() * 100f > 0.2) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.GRAPPLING_HOOK.get()) {
                    if (entity instanceof LivingEntity _entity)
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                } else {
                    if (entity instanceof LivingEntity _entity)
                        _entity.swing(InteractionHand.OFF_HAND, true);
                }
                {
                    Level projectileLevel = entity.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                AbstractArrow entityToSpawn = new Hook(ModEntityTypes.GRAPPLING_HOOK.get(), level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.pickup = AbstractArrow.Pickup.DISALLOWED;
                                entityToSpawn.setSilent(false);
                                return entityToSpawn;
                            }
                        }.getArrow(projectileLevel, entity, 0, 0);
                        _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float) 2, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
                {
                    Scoreboard _sc = entity.level().getScoreboard();
                    Objective _so = _sc.getObjective("killHook");
                    if (_so == null)
                        _so = _sc.addObjective("killHook", ObjectiveCriteria.DUMMY, Component.literal("killHook"), ObjectiveCriteria.RenderType.INTEGER);
                    _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(0);
                }
                Volatility.queueServerWork(1, () -> {
                    {
                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                            entity.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level()
                                            instanceof ServerLevel ? (ServerLevel) entity.level() : null,
                                            4, entity.getName().getString(), entity.getDisplayName(),
                                            Objects.requireNonNull(entity.level().getServer()), entity),
                                    "/playsound minecraft:item.trident.throw player @a ~ ~ ~ 0.7 0.8");
                        }
                    }
                });
                if (entity instanceof Player _player)
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 3);
            }
        }
    }
}


