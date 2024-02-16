package net.hollowed.volatility.common.event;

import net.hollowed.volatility.Volatility;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class DeathEvent {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        Volatility.queueServerWork(1, () -> {

                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                            _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                    "/execute at @e[tag=death] run particle volatility:death_sweep ~ ~ ~");
                        }
                    }
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(
                            new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                    _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                    _ent.getDisplayName(), _ent.level().getServer(), _ent),
                            "/execute at @e[tag=death] run playsound minecraft:entity.player.attack.sweep player @a ~ ~ ~ 0.5 1");
                }
            }
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                            _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                    "/execute at @e[tag=death] run kill @e[distance=..2,type=!player]");
                        }
                    }
                });
            }
        }
