package net.hollowed.volatility.common.block.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class InferniumPlaced {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
            world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.FIRE.defaultBlockState(), 3);
        }
    }
}

