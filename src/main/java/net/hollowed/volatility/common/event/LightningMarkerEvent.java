package net.hollowed.volatility.common.event;

import net.hollowed.volatility.Volatility;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class LightningMarkerEvent {
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
                                    "/execute at @e[tag=lightning] run particle volatility:electrical_crackle ~ ~ ~ 2 2 2 0.01 30 normal");
                        }
                    }
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                            _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                    "/execute at @e[tag=lightning] run particle volatility:friction_sparks ~ ~2 ~ 0 0 0 0.2 50 normal");
                        }
                    }
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                            _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                    "execute at @e[tag=lightning] run playsound minecraft:item.trident.thunder player @a ~ ~ ~ 5");
                        }
                    }
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                            _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                    "execute at @e[tag=lightning] run summon minecraft:lightning_bolt ~ ~ ~");
                        }
                    }
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands()
                                    .performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                            _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[tag=lightning]");
                        }
                    }
                });
            }
        }
