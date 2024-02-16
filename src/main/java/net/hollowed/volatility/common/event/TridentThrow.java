package net.hollowed.volatility.common.event;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.LevelAccessor;

public class TridentThrow {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = new ThrownTrident(EntityType.TRIDENT, _level);
            entityToSpawn.moveTo(x, y + 1, z, 0, 0);
            entityToSpawn.setYBodyRot(0);
            entityToSpawn.setYHeadRot(0);
            entityToSpawn.setDeltaMovement(((entity.getLookAngle().x) * 3), ((entity.getLookAngle().y) * 3), ((entity.getLookAngle().z) * 3));
            _level.addFreshEntity(entityToSpawn);
        }
    }
}

