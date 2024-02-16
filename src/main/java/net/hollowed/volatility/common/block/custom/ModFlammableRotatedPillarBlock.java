package net.hollowed.volatility.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    private static boolean isFlammable;
    private static int flammability;
    private static int fireSpreadSpeed;

    public ModFlammableRotatedPillarBlock(Properties pProperties, boolean isFlammable, int flammability, int fireSpreadSpeed) {
        super(pProperties);
        ModFlammableRotatedPillarBlock.isFlammable = isFlammable;
        ModFlammableRotatedPillarBlock.flammability = flammability;
        ModFlammableRotatedPillarBlock.fireSpreadSpeed = fireSpreadSpeed;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammability; // 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return fireSpreadSpeed; // 5;
    }

 /*   @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.MAHOGANY_LOG.get())) {
                return ModBlocks.STRIPPED_MAHOGANY_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.MAHOGANY_WOOD.get())) {
                return ModBlocks.STRIPPED_MAHOGANY_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.FIR_LOG.get())) {
                return ModBlocks.STRIPPED_FIR_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.FIR_WOOD.get())) {
                return ModBlocks.STRIPPED_FIR_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
*/

   //     return super.getToolModifiedState(state, context, toolAction, simulate);
    //}
}
