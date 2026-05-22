package com.drmangotea.tfmg.content.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;

public class SalammoniacCrystalItem extends Item {
    public SalammoniacCrystalItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public boolean onEntityItemUpdate(ItemStack itemStack, ItemEntity itemEntity) {
        Level level = itemEntity.level();
        BlockPos blockPos = itemEntity.blockPosition();
        FluidState fluidState = level.getFluidState(blockPos);
        
        if (fluidState.is(FluidTags.WATER)) {
            level.playSound(null, blockPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0f, 1.0f);
        
            ((ServerLevel) level).sendParticles(ParticleTypes.POOF, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, 12, 0.4, 0.4, 0.4, 0.01);
            
            itemStack.setCount(0);
        }
        
        return false;
    }
}
