package net.hollowed.volatility.common.entity.ai;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class CursedRemainsTick {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("cooldown") >= -30) {
            entity.getPersistentData().putDouble("cooldown", (entity.getPersistentData().getDouble("cooldown") - 1));
        }
        if (entity.getPersistentData().getDouble("cooldown1") >= -30) {
            entity.getPersistentData().putDouble("cooldown1", (entity.getPersistentData().getDouble("cooldown1") - 1));
        }
        if (entity.getPersistentData().getDouble("cooldown1") <= 0) {
            entity.getPersistentData().putDouble("attack", (Mth.nextInt(RandomSource.create(), 1, 5)));
            entity.getPersistentData().putDouble("cooldown1", 16);
        }
        if (entity.getPersistentData().getDouble("cooldown2") <= 0) {
            entity.getPersistentData().putDouble("blockCheck", (Mth.nextInt(RandomSource.create(), 1, 3)));
            entity.getPersistentData().putDouble("cooldown2", 7);
        }
    }
}

