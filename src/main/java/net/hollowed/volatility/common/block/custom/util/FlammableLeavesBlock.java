package net.hollowed.volatility.common.block.custom.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FlammableLeavesBlock extends LeavesBlock {
	private static boolean isFlammable;
	private static int flammability;
	private static int fireSpreadSpeed;

	public FlammableLeavesBlock(Properties pProperty, boolean isFlammable, int flammability, int fireSpreadSpeed) {
		super(pProperty);
		FlammableLeavesBlock.isFlammable = isFlammable;
		FlammableLeavesBlock.flammability = flammability;
		FlammableLeavesBlock.fireSpreadSpeed = fireSpreadSpeed;
	}

	@Override
	public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return isFlammable;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return flammability;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return fireSpreadSpeed;
	}
}
