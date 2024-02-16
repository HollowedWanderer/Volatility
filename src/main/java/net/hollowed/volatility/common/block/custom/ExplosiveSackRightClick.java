package net.hollowed.volatility.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class ExplosiveSackRightClick {
    public static void execute(LevelAccessor world, int x, int y, int z, Entity entity) {
        if (entity == null)
            return;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.FLINT_AND_STEEL) {
            world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.FLAME, x, y, z, 100, 0.5, 0.5, 0.5, 0.1);
            if (world instanceof Level _level && !_level.isClientSide())
                _level.explode(null, x, y, z, 6, Level.ExplosionInteraction.TNT);

        }
    }
}


