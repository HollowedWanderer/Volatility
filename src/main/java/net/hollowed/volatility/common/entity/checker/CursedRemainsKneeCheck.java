package net.hollowed.volatility.common.entity.checker;

import net.minecraft.world.entity.Entity;

public class CursedRemainsKneeCheck {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        if (entity.getPersistentData().getDouble("blocking") == 0) {
            return entity.getPersistentData().getDouble("attack") == 5 && entity.getPersistentData().getDouble("cooldown") <= 0;
        }
        return false;
    }
}

