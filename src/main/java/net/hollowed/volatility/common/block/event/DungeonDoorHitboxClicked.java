package net.hollowed.volatility.common.block.event;

import net.hollowed.volatility.common.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class DungeonDoorHitboxClicked {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR.get()) {
			DungeonDoorClicked.execute(world, x, (y - 1), z);
		} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN.get()) {
			DungeonDoorOpenClicked.execute(world, x, (y - 1), z);
		}
	}
}
