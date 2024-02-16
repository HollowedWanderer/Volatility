package net.hollowed.volatility.common.block.custom;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

public class HollowedLogBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    // Define Voxel Shapes for different rotations
    public static final VoxelShape SHAPE_NORTH = Shapes.or(
            box(0, 0, 0, 16, 16, 2),
            box(0, 0, 0, 2, 16, 16),
            box(14, 0, 0, 16, 16, 16),
            box(0, 0, 14, 16, 16, 16));

    public static final VoxelShape SHAPE_EAST = Shapes.or(
            box(14, 0, 0, 16, 16, 16),
            box(0, 0, 0, 16, 16, 2),
            box(0, 0, 14, 16, 16, 16),
            box(0, 0, 0, 2, 16, 16));

    public static final VoxelShape SHAPE_SOUTH = Shapes.or(
            box(0, 0, 0, 16, 16, 2),
            box(0, 0, 0, 2, 16, 16),
            box(14, 0, 0, 16, 16, 16),
            box(0, 0, 14, 16, 16, 16));

    public static final VoxelShape SHAPE_WEST = Shapes.or(
            box(14, 0, 0, 16, 16, 16),
            box(0, 0, 0, 16, 16, 2),
            box(0, 0, 14, 16, 16, 16),
            box(0, 0, 0, 2, 16, 16));

    public static final VoxelShape SHAPE_UP = Shapes.or(
            box(0, 14, 0, 16, 16, 16),
            box(0, 0, 0, 2, 16, 16),
            box(14, 0, 0, 16, 16, 16),
            box(0, 0, 0, 16, 2, 16));

    public static final VoxelShape SHAPE_DOWN = Shapes.or(
            box(0, 14, 0, 16, 16, 16),
            box(0, 0, 0, 2, 16, 16),
            box(14, 0, 0, 16, 16, 16),
            box(0, 0, 0, 16, 2, 16));

    public @NotNull RenderShape getRenderShape(@NotNull BlockState p_54559_) {
        return RenderShape.MODEL;
    }

    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState p_54584_, @NotNull BlockGetter p_54585_, @NotNull BlockPos p_54586_) {
        return SHAPE_UP;
    }

    public HollowedLogBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD).strength(1.5f, 1.5f).noOcclusion().dynamicShape());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case EAST -> SHAPE_EAST;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            default -> Shapes.or(box(0, 0, 14, 16, 16, 16),
                    box(14, 0, 0, 16, 16, 16),
                    box(0, 0, 0, 2, 16, 16),
                    box(0, 0, 0, 16, 16, 2));
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite()).setValue(WATERLOGGED, flag);
    }

    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor world, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }
}
