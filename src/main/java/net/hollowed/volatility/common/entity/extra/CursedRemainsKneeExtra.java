package net.hollowed.volatility.common.entity.extra;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

public class CursedRemainsKneeExtra {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        if (entity instanceof Mob _entity)
            _entity.getNavigation().stop();
        if (entity instanceof CursedRemainsEntity) {
            ((CursedRemainsEntity) entity).setAnimation("empty");
        }
        if (entity instanceof CursedRemainsEntity) {
            ((CursedRemainsEntity) entity).setAnimation("knee");
        }
        entity.getPersistentData().putDouble("cooldown", 15);
        entity.getPersistentData().putDouble("attacking", 1);
        Volatility.queueServerWork(5, ()-> {
            entity.getPersistentData().putDouble("attacking", 0);
        });
        return true;
    }
}


