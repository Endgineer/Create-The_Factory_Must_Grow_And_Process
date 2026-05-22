package com.drmangotea.tfmg.content.decoration;

import com.drmangotea.tfmg.registry.TFMGBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingSalammoniacBlock extends SalammoniacBlock {
    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();
    
    public BuddingSalammoniacBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
    
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(GROWTH_CHANCE) == 0) {
            Direction direction = DIRECTIONS[randomSource.nextInt(DIRECTIONS.length)];
            
            BlockPos directionBlockPos = blockPos.relative(direction);
            BlockState directionBlockState = serverLevel.getBlockState(directionBlockPos);
            
            Block block = null;
            if (canClusterGrowAtState(directionBlockState)) {
                block = TFMGBlocks.SMALL_SALAMMONIAC_BUD.get();
            } else if (directionBlockState.is(TFMGBlocks.SMALL_SALAMMONIAC_BUD.get()) && directionBlockState.getValue(SalammoniacClusterBlock.FACING) == direction) {
                block = TFMGBlocks.MEDIUM_SALAMMONIAC_BUD.get();
            } else if (directionBlockState.is(TFMGBlocks.MEDIUM_SALAMMONIAC_BUD.get()) && directionBlockState.getValue(SalammoniacClusterBlock.FACING) == direction) {
                block = TFMGBlocks.LARGE_SALAMMONIAC_BUD.get();
            } else if (directionBlockState.is(TFMGBlocks.LARGE_SALAMMONIAC_BUD.get()) && directionBlockState.getValue(SalammoniacClusterBlock.FACING) == direction) {
                block = TFMGBlocks.SALAMMONIAC_CLUSTER.get();
            }
            
            if (block != null) {
                BlockState newBlockState = block.defaultBlockState().setValue(SalammoniacClusterBlock.FACING, direction).setValue(SalammoniacClusterBlock.WATERLOGGED, Boolean.valueOf(directionBlockState.getFluidState().getType() == Fluids.WATER));
                serverLevel.setBlockAndUpdate(blockPos, newBlockState);
            }
        }
    }
   
    public static boolean canClusterGrowAtState(BlockState blockState) {
        return blockState.isAir();
    }
}
