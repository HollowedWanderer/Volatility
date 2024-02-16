package net.hollowed.volatility.common.block.custom;

/**
public class FirSapling extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final AbstractTreeGrower treeGrower;

    public FirSapling(AbstractTreeGrower p_55978_, BlockBehaviour.Properties p_55979_) {
        super(p_55979_);
        this.treeGrower = p_55978_;
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
    }

    public VoxelShape getShape(BlockState p_56008_, BlockGetter p_56009_, BlockPos p_56010_, CollisionContext p_56011_) {
        return SHAPE;
    }

    public void randomTick(BlockState p_222011_, ServerLevel p_222012_, BlockPos p_222013_, RandomSource p_222014_) {
        if (!p_222012_.isAreaLoaded(p_222013_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (p_222012_.getMaxLocalRawBrightness(p_222013_.above()) >= 9 && p_222014_.nextInt(7) == 0) {
            this.advanceTree(p_222012_, p_222013_, p_222011_, p_222014_);
        }

    }

    public void advanceTree(ServerLevel p_222001_, BlockPos p_222002_, BlockState p_222003_, RandomSource p_222004_) {
        if (p_222003_.getValue(STAGE) == 0) {
            p_222001_.setBlock(p_222002_, p_222003_.cycle(STAGE), 4);
        } else {
            FirTreeGrower.execute(p_222001_, p_222002_.getX(), p_222002_.getY(), p_222002_.getZ());
        }
    }

    public boolean isValidBonemealTarget(BlockGetter p_55991_, BlockPos p_55992_, BlockState p_55993_, boolean p_55994_) {
        return true;
    }

    public boolean isBonemealSuccess(Level p_222006_, RandomSource p_222007_, BlockPos p_222008_, BlockState p_222009_) {
        return (double)p_222006_.random.nextFloat() < 0.45D;
    }

    public void performBonemeal(ServerLevel p_221996_, RandomSource p_221997_, BlockPos p_221998_, BlockState p_221999_) {
        this.advanceTree(p_221996_, p_221998_, p_221999_, p_221997_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56001_) {
        p_56001_.add(STAGE);
    }
}
**/