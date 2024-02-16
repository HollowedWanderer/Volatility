package net.hollowed.volatility.common.block.custom;

import net.hollowed.volatility.common.block.entity.custom.PedestalTile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class PedestalBlock extends BaseEntityBlock {
    public static final VoxelShape SHAPE_COLUMN = Block.box(3, 3, 3, 13, 13, 13);
    public static final VoxelShape SHAPE_BOTTOM = Block.box(1, 0, 1, 15, 3, 15);
    public static final VoxelShape SHAPE_TOP = Block.box(1, 13, 1, 15, 16, 15);

    public static final VoxelShape SHAPE = Shapes.or(SHAPE_BOTTOM, SHAPE_TOP, SHAPE_COLUMN);
    public PedestalBlock() {
        super(Properties.copy(Blocks.LODESTONE).noOcclusion());
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level pLevel, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pos);
            if (entity instanceof PedestalTile pedestalTile) {

                ItemStack currentPedestalItem = pedestalTile.getHeldItem();
                ItemStack handItem = player.getItemInHand(hand);

                ItemStack playerItem = currentPedestalItem.copy();
                if (handItem.isEmpty() || handItem.getCount() == 1) {
                    player.setItemInHand(hand, playerItem);
                } else {
                    dropItem(playerItem, player);
                }
                pedestalTile.setHeldItem(ItemStack.EMPTY);


                currentPedestalItem = handItem.copy();
                if (!currentPedestalItem.isEmpty()) {
                    currentPedestalItem.setCount(1);
                    pedestalTile.setHeldItem(currentPedestalItem);
                    handItem.shrink(1);
                }
                pLevel.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    private void dropItem(ItemStack itemstack, Player owner) {
        if (owner instanceof ServerPlayer serverplayer) {
            ItemEntity itementity = serverplayer.drop(itemstack, false);
            if (itementity != null) {
                itementity.setNoPickUpDelay();
                itementity.setThrower(serverplayer.getUUID());
            }
        }
    }

    @Override
    public void onRemove(BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof PedestalTile) {
                ((PedestalTile) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new PedestalTile(pos, state);
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }
}