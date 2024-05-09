package net.hollowed.volatility.common.event;

import dev.kosmx.playerAnim.core.util.Vec3d;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class HookGroundTick {
    public static void execute(Entity entity, Entity entityOwner, LevelAccessor world) {
        if (entity == null || entityOwner == null)
            return;
    }

}

