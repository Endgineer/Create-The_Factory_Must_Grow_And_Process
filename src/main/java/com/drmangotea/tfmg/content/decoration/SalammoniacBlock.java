package com.drmangotea.tfmg.content.decoration;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SalammoniacBlock extends Block {
    public SalammoniacBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
   
    public void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        if (!level.isClientSide) {
            BlockPos blockpos = blockHitResult.getBlockPos();
            level.playSound((Player) null, blockpos, SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.BLOCKS, 1.0F, 0.5F + level.random.nextFloat() * 1.2F);
            level.playSound((Player) null, blockpos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.0F, 0.5F + level.random.nextFloat() * 1.2F);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onPlace(BlockState newBlockState, Level level, BlockPos newBlockPos, BlockState oldBlockState, boolean isMoving) {
        super.onPlace(newBlockState, level, newBlockPos, oldBlockState, isMoving);
        if (!level.isClientSide && isTouchingWater(level, newBlockPos)) {
            dissolve(level, newBlockPos);
        }
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos newBlockPos, Block block, BlockPos oldBlockPos, boolean isMoving) {
        super.neighborChanged(blockState, level, newBlockPos, block, oldBlockPos, isMoving);
        if (!level.isClientSide && isTouchingWater(level, newBlockPos)) {
            dissolve(level, newBlockPos);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState neighborBlockState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos neighborBlockPos) {
        if (!levelAccessor.isClientSide() && isTouchingWater(levelAccessor, blockPos)) {
            if (levelAccessor instanceof Level level) {
                dissolve(level, blockPos);
            }
        }
        
        return super.updateShape(blockState, direction, neighborBlockState, levelAccessor, blockPos, neighborBlockPos);
    }

    private boolean isTouchingWater(LevelAccessor levelAccessor, BlockPos blockPos) {
        for (Direction direction : Direction.values()) {
            if (levelAccessor.getFluidState(blockPos.relative(direction)).is(FluidTags.WATER)) {
                return true;
            }
        }
    
        return false;
    }

    private void dissolve(Level level, BlockPos blockPos) {
        level.playSound(null, blockPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0f, 1.0f);
    
        ((ServerLevel) level).sendParticles(ParticleTypes.POOF, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, 12, 0.4, 0.4, 0.4, 0.01);
    
        level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
    }
}
