package net.hollowed.volatility.common.entity.ai;

import net.minecraft.world.entity.Entity;

public class CursedRemainsSpawn {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        entity.getPersistentData().putDouble("cooldown", 60);
    }
}

