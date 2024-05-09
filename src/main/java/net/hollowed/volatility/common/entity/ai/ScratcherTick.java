package net.hollowed.volatility.common.entity.ai;

import net.hollowed.volatility.common.entity.entities.ScratcherEntity;
import net.minecraft.world.entity.Entity;

public class ScratcherTick {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("hurtCooldown") >= -30) {
            entity.getPersistentData().putDouble("hurtCooldown", (entity.getPersistentData().getDouble("hurtCooldown") - 1));
        }
        if (entity.getPersistentData().getDouble("hurtCooldown") <= -15) {
            if (entity instanceof ScratcherEntity) {
                ((ScratcherEntity) entity).setTexture("scratcher");
            }
        }
    }
}




