package net.hollowed.volatility.common.event;

import net.hollowed.volatility.Volatility;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;

import java.util.Objects;

public class HookHitEntity {
    public static void execute(Entity immediatesourceentity, Entity entity) {
        if (entity == null)
            return;
        {
            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
                immediatesourceentity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, immediatesourceentity.position(), immediatesourceentity.getRotationVector(), immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel) immediatesourceentity.level() : null, 4,
                        immediatesourceentity.getName().getString(), immediatesourceentity.getDisplayName(), Objects.requireNonNull(immediatesourceentity.level().getServer()), immediatesourceentity), "kill @s");
            }
            Volatility.queueServerWork(2, ()-> {
                {
                    if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
                        immediatesourceentity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, immediatesourceentity.position(), immediatesourceentity.getRotationVector(),
                                immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel) immediatesourceentity.level() : null, 4,
                                immediatesourceentity.getName().getString(), immediatesourceentity.getDisplayName(), Objects.requireNonNull(immediatesourceentity.level().getServer()),
                                immediatesourceentity), "kill @e[tag=hook,limit=1,sort=nearest]");
                    }
                }
                {
                    if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
                        immediatesourceentity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, immediatesourceentity.position(), immediatesourceentity.getRotationVector(),
                                immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel) immediatesourceentity.level() : null, 4,
                                immediatesourceentity.getName().getString(), immediatesourceentity.getDisplayName(), Objects.requireNonNull(immediatesourceentity.level().getServer()),
                                immediatesourceentity), "kill @e[tag=hook2,limit=1,sort=nearest]");
                    }
                }
                Volatility.queueServerWork(1, () -> {
                    Volatility.queueServerWork(1, () -> {
                        {
                            if (!immediatesourceentity.level().isClientSide() && immediatesourceentity.getServer() != null) {
                                immediatesourceentity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, immediatesourceentity.position(), immediatesourceentity.getRotationVector(),
                                        immediatesourceentity.level() instanceof ServerLevel ? (ServerLevel) immediatesourceentity.level() : null, 4,
                                        immediatesourceentity.getName().getString(), immediatesourceentity.getDisplayName(), Objects.requireNonNull(immediatesourceentity.level().getServer()),
                                        immediatesourceentity), "/kill @e[type=item,limit=1,sort=nearest,nbt={Item:{id:\"minecraft:lead\",Count:1b}}]");
                            }
                        }
                    });
                    {
                        Scoreboard _sc = entity.level().getScoreboard();
                        Objective _so = _sc.getObjective("hookCooldown");
                        if (_so == null)
                            _so = _sc.addObjective("hookCooldown", ObjectiveCriteria.DUMMY, Component.literal("hookCooldown"), ObjectiveCriteria.RenderType.INTEGER);
                        _sc.getOrCreatePlayerScore(entity.getScoreboardName(), _so).setScore(0);
                    }
                });
            });
        }
    }
}

