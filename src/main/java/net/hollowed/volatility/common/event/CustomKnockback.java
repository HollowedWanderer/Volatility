package net.hollowed.volatility.common.event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class CustomKnockback {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        entity.setDeltaMovement(
                new Vec3((sourceentity.getDeltaMovement().x() + sourceentity.getLookAngle().x) * 1.75, (sourceentity.getDeltaMovement().y() + sourceentity.getLookAngle().y) * 1.75, (sourceentity.getDeltaMovement().z() + sourceentity.getLookAngle().z) * 1.75));
    }
}
