package net.hollowed.volatility.common.block.event;

import net.hollowed.volatility.common.block.ModBlocks;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class DungeonDoorPlaced {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))) == Direction.NORTH) {
			if (((world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z)) || (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z)) || (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) || (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x + 1, y + 2, z)) || (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x - 1, y + 2, z)) || (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 3, z)) || (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x + 1, y + 3, z)) || (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x - 1, y + 3, z)) || (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~ ~ ~1 ~3 ~ volatility:dungeon_door_hitbox[facing=north] replace air");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~ ~ ~1 ~3 ~ volatility:dungeon_door_hitbox[facing=north] replace volatility:dungeon_door_open_hitbox");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~ ~ ~1 ~3 ~ air replace #volatility:dungeon_door_blocks");
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);

			}
		} else if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))) == Direction.SOUTH) {
			if (((world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z)) || (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z)) || (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) || (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x + 1, y + 2, z)) || (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x - 1, y + 2, z)) || (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 3, z)) || (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x + 1, y + 3, z)) || (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x - 1, y + 3, z)) || (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~ ~ ~1 ~3 ~ volatility:dungeon_door_hitbox[facing=north] replace air");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~ ~ ~1 ~3 ~ volatility:dungeon_door_hitbox[facing=north] replace volatility:dungeon_door_open_hitbox");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~ ~ ~1 ~3 ~ air replace #volatility:dungeon_door_blocks");
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);

			}
		} else if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))) == Direction.WEST) {
			if (((world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 1)) || (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 1, z - 1)) || (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 2, z + 1)) || (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 2, z - 1)) || (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) || (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 3, z + 1)) || (world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 3, z - 1)) || (world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 3, z)) || (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~ ~ ~-1 ~ ~3 ~1 volatility:dungeon_door_hitbox[facing=east] replace air");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~ ~ ~-1 ~ ~3 ~1 volatility:dungeon_door_hitbox[facing=east] replace volatility:dungeon_door_open_hitbox");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~ ~ ~-1 ~ ~3 ~1 air replace #volatility:dungeon_door_blocks");
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))) == Direction.EAST) {
			if (((world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 1)) || (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 1, z - 1)) || (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 2, z + 1)) || (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 2, z - 1)) || (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) || (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 3, z + 1)) || (world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 3, z - 1)) || (world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())
					&& ((world.isEmptyBlock(BlockPos.containing(x, y + 3, z)) || (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_OPEN_HITBOX.get()) || (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == ModBlocks.DUNGEON_DOOR_HITBOX.get())) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~ ~ ~-1 ~ ~3 ~1 volatility:dungeon_door_hitbox[facing=east] replace air");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~ ~ ~-1 ~ ~3 ~1 volatility:dungeon_door_hitbox[facing=east] replace volatility:dungeon_door_open_hitbox");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~ ~ ~-1 ~ ~3 ~1 air replace #volatility:dungeon_door_blocks");
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
