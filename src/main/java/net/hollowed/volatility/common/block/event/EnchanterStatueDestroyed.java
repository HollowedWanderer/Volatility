package net.hollowed.volatility.common.block.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class EnchanterStatueDestroyed {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
    }
}
