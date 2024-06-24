package net.hollowed.volatility.common.entity.checker;

import net.minecraft.world.entity.Entity;

public class CursedRemainsSwingCheck {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return (entity.getPersistentData().getDouble("attack") == 1 || entity.getPersistentData().getDouble("attack") == 3
                    || entity.getPersistentData().getDouble("attack") == 4) && entity.getPersistentData().getDouble("cooldown") <= 0;
    }
}

