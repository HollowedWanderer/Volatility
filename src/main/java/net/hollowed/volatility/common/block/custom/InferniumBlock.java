package net.hollowed.volatility.common.block.custom;

import net.hollowed.volatility.common.block.event.InferniumPlaced;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class InferniumBlock extends Block {
    public InferniumBlock() {
        super(Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL).strength(6f, 7f).requiresCorrectToolForDrops());
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        InferniumPlaced.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
        super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
        InferniumPlaced.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }

}

