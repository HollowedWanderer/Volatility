package net.hollowed.volatility.common.event;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.effect.ModEffects;
import net.hollowed.volatility.common.network.ModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;

import java.util.Objects;

public class HookFlyingTick {
    public static void execute(Entity entity, Entity immediatesourceentity) {
        if (entity == null || immediatesourceentity == null) {
            //assert immediatesourceentity != null;
            //immediatesourceentity.discard();
            return;
        }

        if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
            // Define start and end positions
            double startX = immediatesourceentity.getX();
            double startY = immediatesourceentity.getY();
            double startZ = immediatesourceentity.getZ();
            double endX = entity.getX();
            double endY = entity.getY();
            double endZ = entity.getZ();

            // Calculate distance between start and end points
            double deltaX = endX - startX;
            double deltaY = endY - startY;
            double deltaZ = endZ - startZ;
            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

            // Number of particles to spawn
            int steps = (int) distance * 2;

            // Spawn particles along the line
            for (int i = 0; i < steps; i++) {
                double ratio = (double) i / steps;
                double particleX = startX + deltaX * ratio;
                double particleY = startY + deltaY * ratio;
                double particleZ = startZ + deltaZ * ratio;

                // Spawn particle at the calculated position using /particle command
                String particleCommand = String.format("particle volatility:sand_rope %f %f %f 0 0 0 0 1", particleX, particleY, particleZ);
                immediatesourceentity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, immediatesourceentity.position(), immediatesourceentity.getRotationVector(),
                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel) immediatesourceentity.level() : null, 4,
                        immediatesourceentity.getName().getString(), immediatesourceentity.getDisplayName(), Objects.requireNonNull(immediatesourceentity.level().getServer()),
                        immediatesourceentity), particleCommand);
            }
        }

        if (45 <= Math.sqrt(Math.pow(entity.getX() - immediatesourceentity.getX(), 2) + Math.pow(entity.getY() - immediatesourceentity.getY(), 2) + Math.pow(entity.getZ() - immediatesourceentity.getZ(), 2))) {
            {
                if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
                    immediatesourceentity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, immediatesourceentity.position(), immediatesourceentity.getRotationVector(),
                            immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel) immediatesourceentity.level() : null, 4,
                            immediatesourceentity.getName().getString(), immediatesourceentity.getDisplayName(), Objects.requireNonNull(immediatesourceentity.level().getServer()),
                            immediatesourceentity), "kill @s");
                }
            }
            {
                if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
                    immediatesourceentity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, immediatesourceentity.position(), immediatesourceentity.getRotationVector(),
                            immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel) immediatesourceentity.level() : null, 4,
                            immediatesourceentity.getName().getString(), immediatesourceentity.getDisplayName(), Objects.requireNonNull(immediatesourceentity.level().getServer()),
                            immediatesourceentity), "kill @e[tag=hook,limit=1,sort=nearest]");
                }
            }

            Volatility.queueServerWork(1, () -> {
                {
                    Scoreboard _sc = entity.level().getScoreboard();
                    Objective _so = _sc.getObjective("hookCooldown");
                    if (_so == null)
                        _so = _sc.addObjective("hookCooldown", ObjectiveCriteria.DUMMY, Component.literal("hookCooldown"), ObjectiveCriteria.RenderType.INTEGER);
                    _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(0);
                }
                {
                    boolean _setval = false;
                    entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.hooked = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            });
        } else {
            {
                Scoreboard _sc = entity.level().getScoreboard();
                Objective _so = _sc.getObjective("hookCooldown");
                if (_so == null)
                    _so = _sc.addObjective("hookCooldown", ObjectiveCriteria.DUMMY, Component.literal("hookCooldown"), ObjectiveCriteria.RenderType.INTEGER);
                _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(1);
            }
            if (new Object() {
                public int getScore(String score, Entity _ent) {
                    Scoreboard _sc = _ent.level().getScoreboard();
                    Objective _so = _sc.getObjective(score);
                    if (_so != null)
                        return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
                    return 0;
                }
            }.getScore("killHook", entity) == 1) {
                {
                    if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
                        immediatesourceentity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, immediatesourceentity.position(), immediatesourceentity.getRotationVector(), immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel) immediatesourceentity.level() : null, 4,
                                immediatesourceentity.getName().getString(), immediatesourceentity.getDisplayName(), Objects.requireNonNull(immediatesourceentity.level().getServer()), immediatesourceentity), "kill @s");
                    }
                    {
                        if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
                            immediatesourceentity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, immediatesourceentity.position(), immediatesourceentity.getRotationVector(),
                                    immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel) immediatesourceentity.level() : null, 4,
                                    immediatesourceentity.getName().getString(), immediatesourceentity.getDisplayName(), Objects.requireNonNull(immediatesourceentity.level().getServer()),
                                    immediatesourceentity), "kill @e[tag=hook,limit=1,sort=nearest]");
                        }
                    }
                    Volatility.queueServerWork(1, () -> {
                        {
                            Scoreboard _sc = entity.level().getScoreboard();
                            Objective _so = _sc.getObjective("hookCooldown");
                            if (_so == null)
                                _so = _sc.addObjective("hookCooldown", ObjectiveCriteria.DUMMY, Component.literal("hookCooldown"), ObjectiveCriteria.RenderType.INTEGER);
                            _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(0);
                        }
                    });
                }
            } else {
                {
                    Scoreboard _sc = entity.level().getScoreboard();
                    Objective _so = _sc.getObjective("killHook");
                    if (_so == null)
                        _so = _sc.addObjective("killHook", ObjectiveCriteria.DUMMY, Component.literal("killHook"), ObjectiveCriteria.RenderType.INTEGER);
                    _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(0);
                }
            }
        }
    }
}

