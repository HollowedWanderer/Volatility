package net.hollowed.volatility.common.entity.extra;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class CursedRemainsSwingExtra {
    public static boolean execute(LevelAccessor world, Entity entity, double x, double y, double z) {
        if (entity == null)
            return false;
        if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                if (entity instanceof Mob _entity)
                    _entity.getNavigation().stop();
                if (entity instanceof CursedRemainsEntity) {
                    ((CursedRemainsEntity) entity).setAnimation("empty");
                }
                if (entity instanceof CursedRemainsEntity) {
                    ((CursedRemainsEntity) entity).setAnimation("swing1");
                }
            } else {
                if (entity instanceof Mob _entity)
                    _entity.getNavigation().stop();
                if (entity instanceof CursedRemainsEntity) {
                    ((CursedRemainsEntity) entity).setAnimation("empty");
                }
                if (entity instanceof CursedRemainsEntity) {
                    ((CursedRemainsEntity) entity).setAnimation("swing2");
                }
            }
        entity.getPersistentData().putDouble("cooldown", 40);
        entity.getPersistentData().putDouble("attacking", 1);
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
        Volatility.queueServerWork(30, ()-> {
            entity.getPersistentData().putDouble("attacking", 0);
        });
        return true;
    }
}


