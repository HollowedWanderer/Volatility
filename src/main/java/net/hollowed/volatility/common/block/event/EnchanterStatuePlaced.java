package net.hollowed.volatility.common.block.event;

import net.hollowed.volatility.common.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class EnchanterStatuePlaced {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
        if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
            world.setBlock(BlockPos.containing(x, y + 1, z), ModBlocks.ENCHANTER_STATUE_TOP.get().defaultBlockState(), 3);
            if ((new Object() {
                public Direction getDirection(BlockState _bs) {
                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (_prop instanceof DirectionProperty _dp)
                        return _bs.getValue(_dp);
                    _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                    return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
                }
            }.getDirection(blockstate)) == Direction.NORTH) {
                {
                    Direction _dir = Direction.NORTH;
                    BlockPos _pos = BlockPos.containing(x, y + 1, z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                        world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
                    } else {
                        _property = _bs.getBlock().getStateDefinition().getProperty("axis");
                        if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
                            world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
                    }
                }
            }
            if ((new Object() {
                public Direction getDirection(BlockState _bs) {
                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (_prop instanceof DirectionProperty _dp)
                        return _bs.getValue(_dp);
                    _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                    return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
                }
            }.getDirection(blockstate)) == Direction.SOUTH) {
                {
                    Direction _dir = Direction.SOUTH;
                    BlockPos _pos = BlockPos.containing(x, y + 1, z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                        world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
                    } else {
                        _property = _bs.getBlock().getStateDefinition().getProperty("axis");
                        if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
                            world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
                    }
                }
            }
            if ((new Object() {
                public Direction getDirection(BlockState _bs) {
                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (_prop instanceof DirectionProperty _dp)
                        return _bs.getValue(_dp);
                    _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                    return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
                }
            }.getDirection(blockstate)) == Direction.WEST) {
                {
                    Direction _dir = Direction.WEST;
                    BlockPos _pos = BlockPos.containing(x, y + 1, z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                        world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
                    } else {
                        _property = _bs.getBlock().getStateDefinition().getProperty("axis");
                        if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
                            world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
                    }
                }
            }
            if ((new Object() {
                public Direction getDirection(BlockState _bs) {
                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (_prop instanceof DirectionProperty _dp)
                        return _bs.getValue(_dp);
                    _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                    return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
                }
            }.getDirection(blockstate)) == Direction.EAST) {
                {
                    Direction _dir = Direction.EAST;
                    BlockPos _pos = BlockPos.containing(x, y + 1, z);
                    BlockState _bs = world.getBlockState(_pos);
                    Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                        world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
                    } else {
                        _property = _bs.getBlock().getStateDefinition().getProperty("axis");
                        if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
                            world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
                    }
                }
            }
        } else {
            BlockPos _pos = BlockPos.containing(x, y, z);
            Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
            world.destroyBlock(_pos, false);
        }
    }
}

