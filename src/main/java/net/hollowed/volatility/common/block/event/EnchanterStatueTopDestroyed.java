package net.hollowed.volatility.common.block.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class EnchanterStatueTopDestroyed {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        {
            BlockPos _pos = BlockPos.containing(x, y - 1, z);
            Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y - 1, z), null);
            world.destroyBlock(_pos, false);
        }
    }
}

