package net.pometia.dragonshoard.block.custom.idol;

import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.pometia.dragonshoard.block.entity.idol.MarIdolBlockEntity;
import net.pometia.dragonshoard.block.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class MarIdolBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final int field_31075 = 3;
    private static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 5.0, 5.0, 11.0, 11.0, 11.0);

    public MarIdolBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MarIdolBlockEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.MAR_IDOL_BE, world.isClient ? MarIdolBlockEntity::clientTick : MarIdolBlockEntity::serverTick);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

//    @Override
//    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
//        if (itemStack.hasCustomName()) {
//            BlockEntity blockEntity = world.getBlockEntity(pos);
//            if (blockEntity instanceof BeaconBlockEntity) {
//                ((BeaconBlockEntity)blockEntity).setCustomName(itemStack.getName());
//            }
//        }
//    }
//    @Override
//    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
//        return false;
//    }
}
