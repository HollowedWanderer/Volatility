package net.hollowed.volatility.common.item.custom;

import net.hollowed.volatility.common.event.StickStickingClicking;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class SharpObjectCooldown {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (entity instanceof Player _player)
            _player.getCooldowns().addCooldown(itemstack.getItem(), 4);
        StickStickingClicking.execute(world, x, y, z);
    }
}
