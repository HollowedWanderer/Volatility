package net.hollowed.volatility.common.block.event;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.block.ModBlocks;
import net.hollowed.volatility.common.entity.ModEntityTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ArmorPileDestroy {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        {
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
                world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
        }
        Volatility.queueServerWork(1, () -> {
            Volatility.queueServerWork(12, () -> {
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.ARMOR_PILE.get()) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9, false);
                        }
                    }
                }
            });
            Volatility.queueServerWork(14, () -> {
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.ARMOR_PILE.get()) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.1);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.1, false);
                        }
                    }
                }
            });
            Volatility.queueServerWork(15, () -> {
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.ARMOR_PILE.get()) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.2);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.2, false);
                        }
                    }
                }
            });
            Volatility.queueServerWork(17, () -> {
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.ARMOR_PILE.get()) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.4);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.4, false);
                        }
                    }
                }
            });
            Volatility.queueServerWork(19, () -> {
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.ARMOR_PILE.get()) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.5);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.5, false);
                        }
                    }
                }
            });
            Volatility.queueServerWork(21, () -> {
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.ARMOR_PILE.get()) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.6);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 1.6, false);
                        }
                    }
                }
            });
            {
                int _value = 1;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
            }
            Volatility.queueServerWork(30, () -> {
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ModBlocks.ARMOR_PILE.get()) {
                    world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = ModEntityTypes.CURSED_REMAINS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0, 0, 0);
                        }
                    }
                    if (world instanceof ServerLevel _level)
                        _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                "particle minecraft:cloud ~ ~ ~ 0.3 1.25 0.3 0.03 60 force");
                }
            });
        });
    }
}




