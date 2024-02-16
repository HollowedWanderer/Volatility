package net.hollowed.volatility.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class FeatherSack extends HayBlock {
    public FeatherSack() {
        super(Properties.copy(Blocks.WHITE_WOOL).sound(SoundType.WOOL).strength(0.7f, 1f));
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}


