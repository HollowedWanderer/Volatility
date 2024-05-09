package net.hollowed.volatility.common.event;

import net.hollowed.volatility.Volatility;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TreeGrow {
    @SubscribeEvent
    public static void onSaplingGrow(SaplingGrowTreeEvent event) {
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
    }

    public static void execute(LevelAccessor world, double x, double y, double z) {
        execute(null, world, x, y, z);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
        Volatility.queueServerWork(4, ()-> {
                if (world instanceof Level _level)
                    _level.updateNeighborsAt(BlockPos.containing(x, y, z - 1), _level.getBlockState(BlockPos.containing(x, y, z - 1)).getBlock());
                if (world instanceof Level _level)
                    _level.updateNeighborsAt(BlockPos.containing(x + 1, y, z - 1), _level.getBlockState(BlockPos.containing(x + 1, y, z - 1)).getBlock());
                if (world instanceof Level _level)
                    _level.updateNeighborsAt(BlockPos.containing(x + 1, y, z), _level.getBlockState(BlockPos.containing(x + 1, y, z)).getBlock());
        });
    }
}

