package net.hollowed.volatility.common.entity.ai;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.block.ModBlocks;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Objects;

public class CursedRemainsDies {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        Volatility.queueServerWork(6, () -> {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9, false);
                }
            }
        });
        Volatility.queueServerWork(8, () -> {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9, false);
                }
            }
        });
        Volatility.queueServerWork(9, () -> {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9, false);
                }
            }
        });
        Volatility.queueServerWork(11, () -> {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9, false);
                }
            }
        });
        Volatility.queueServerWork(13, () -> {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9, false);
                }
            }
        });
        Volatility.queueServerWork(15, () -> {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.place"))), SoundSource.HOSTILE, 1, (float) 0.9, false);
                }
            }
        });
        Volatility.queueServerWork(26, () -> {
            if (world instanceof ServerLevel _level)
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                        "setblock ~ ~ ~ volatility:armor_pile");
            if (world instanceof ServerLevel _level)
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                        "particle minecraft:cloud ~ ~ ~ 0.3 0.3 0.3 0.03 60 force");
        });
    }
}

