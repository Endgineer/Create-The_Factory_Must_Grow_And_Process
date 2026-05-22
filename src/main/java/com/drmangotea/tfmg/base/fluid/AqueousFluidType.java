package com.drmangotea.tfmg.base.fluid;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import com.tterrag.registrate.builders.FluidBuilder;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;

import com.drmangotea.tfmg.registry.TFMGFluids;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;

import static com.drmangotea.tfmg.registry.TFMGFluids.getAqueousTexture;

public class AqueousFluidType extends TFMGFluids.SolidRenderedPlaceableFluidType {
    final int color;

    public AqueousFluidType(FluidType.Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture, int color) {
        super(properties, stillTexture, flowingTexture);
        this.color = color;
    }

    public static FluidBuilder.FluidTypeFactory create(int color) {
        return (p, s, f) -> {
            AqueousFluidType fluidType = new AqueousFluidType(p, s, f, color);
            return fluidType;
        };
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return getAqueousTexture();
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return getAqueousTexture();
            }

            @Override
            public int getTintColor(FluidStack stack) {
                return color;
            }

            @Override
            public int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
                return color;
            }

            @Override
            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                Vector3f customFogColor = AqueousFluidType.this.getCustomFogColor();
                return customFogColor == null ? fluidFogColor : customFogColor;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                float modifier = AqueousFluidType.this.getFogDistanceModifier();
                float baseWaterFog = 96.0f;
                if (modifier != 1f) {
                    RenderSystem.setShaderFogShape(FogShape.CYLINDER);
                    RenderSystem.setShaderFogStart(-8);
                    RenderSystem.setShaderFogEnd(baseWaterFog * modifier);
                }
            }
        });
    }
}
