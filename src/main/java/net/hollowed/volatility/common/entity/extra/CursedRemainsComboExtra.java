package net.hollowed.volatility.common.entity.extra;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class CursedRemainsComboExtra {
    public static void execute(LevelAccessor world, Entity entity, double x, double y, double z) {
        if (entity == null)
            return;
        if (entity instanceof CursedRemainsEntity) {
            entity.getPersistentData().putDouble("cooldown", 65);
            ((CursedRemainsEntity) entity).setAnimation("double_swing");
            Volatility.queueServerWork(7, () -> {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain"))), SoundSource.HOSTILE, 1, (float) 0.9);
                    } else {
                        _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain"))), SoundSource.HOSTILE, 1, (float) 0.9, false);
                    }
                }
            });
            Volatility.queueServerWork(14, () -> {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("volatility:sword_hit"))), SoundSource.HOSTILE, 1, (float) 0.6);
                    } else {
                        _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("volatility:sword_hit"))), SoundSource.HOSTILE, 1, (float) 0.6, false);
                    }
                }
            });
            Volatility.queueServerWork(32, () -> {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("volatility:sword_hit"))), SoundSource.HOSTILE, 1, (float) 0.6);
                    } else {
                        _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("volatility:sword_hit"))), SoundSource.HOSTILE, 1, (float) 0.6, false);
                    }
                }
            });
        }
    }
}



