package com.drmangotea.tfmg.datagen.recipes.values.tfmg;

import com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider;
import com.drmangotea.tfmg.datagen.recipes.builder.VatMachineRecipeBuilder;
import com.drmangotea.tfmg.registry.TFMGFluids;
import com.drmangotea.tfmg.registry.TFMGItems;
import com.drmangotea.tfmg.registry.TFMGTags;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;

import java.util.ArrayList;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.ethylene;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.heavyOil;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.liquidPlastic;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.naphtha;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.propylene;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.I.crushedRawIron;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.I.rubber;
import static com.drmangotea.tfmg.datagen.recipes.builder.VatMachineRecipeBuilder.VatRecipeParams;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.I.saltDust;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.I.sulfurDust;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.I.salammoniacCrystal;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hydrogen;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.oxygen;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.chlorine;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sulfurDioxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sulfurTrioxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hydrogenChloride;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.nitrogenOxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.nitrogenDioxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.ammonia;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.water;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.brine;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sodiumHydroxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sulfuricAcid;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hydrochloricAcid;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.nitricAcid;

public class VatRecipeGen extends TFMGRecipeProvider {
    public VatRecipeGen(PackOutput output) {
        super(output);
    }

    GeneratedRecipe
            CONCRETE = createVatRecipe("concrete", b -> (VatMachineRecipeBuilder) b
                    .require(Blocks.SAND.asItem())
                    .require(Blocks.GRAVEL.asItem())
                    .require(TFMGItems.LIMESAND)
                    .require(Fluids.WATER, 250)
                    .output(TFMGFluids.LIQUID_CONCRETE.get(), 1000)
            , mixing()),
            ARC_FURNACE_STEEL = createVatRecipe("arc_furnace_steel", b -> (VatMachineRecipeBuilder) b
                            .require(crushedRawIron())
                            .require(TFMGTags.TFMGItemTags.FLUX.tag)
                            .require(TFMGItems.COAL_COKE_DUST)
                            .output(0.9f,TFMGItems.COAL_COKE_DUST)
                            .output(TFMGFluids.MOLTEN_STEEL.get(), 144)
                            .output(TFMGFluids.MOLTEN_SLAG.get(), 288)
                            .duration(20)
                    , arcBlasting()),
            NEON = createVatRecipe("neon", b -> (VatMachineRecipeBuilder) b
                            .require(TFMGFluids.AIR.get(), 1000)
                            .output(TFMGFluids.NEON.get(), 1)
                            .duration(10)
                    , centrifuge()),

            RUBBER = createVatRecipe("rubber", b -> (VatMachineRecipeBuilder) b
                            .require(heavyOil(), 250)
                            .require(sulfurDust())
                            .output(rubber())
                            .requiresHeat(HeatCondition.HEATED)
                    ,mixing()),

            NAPHTHA = createVatRecipe("naphtha", b -> (VatMachineRecipeBuilder) b
                            .require(naphtha(), 500)
                            .output(ethylene(), 250)
                            .output(propylene(), 250)
                            .requiresHeat(HeatCondition.HEATED)
                    ,mixing()),

            PLASTIC_FROM_ETHYLENE = createVatRecipe("plastic_from_ethylene", b -> (VatMachineRecipeBuilder) b
                            .require(ethylene(), 500)
                            .output(liquidPlastic(), 500)
                            .requiresHeat(HeatCondition.HEATED)
                    ,mixing()),
            PLASTIC_FROM_PROPYLENE = createVatRecipe("plastic_from_propylene", b -> (VatMachineRecipeBuilder) b
                            .require(propylene(), 500)
                            .output(liquidPlastic(), 500)
                            .requiresHeat(HeatCondition.HEATED)
                    ,mixing()),
            ETCHED_CIRCUIT_BOARD = createVatRecipe("etched_circuit_board", b -> (VatMachineRecipeBuilder) b
                            .require(TFMGItems.COATED_CIRCUIT_BOARD)
                            .require(TFMGFluids.SULFURIC_ACID.getSource(), 250)
                            .output(TFMGItems.ETCHED_CIRCUIT_BOARD)
                            .duration(100)
                    , new VatRecipeParams()),
            ALUMINUM = createVatRecipe("aluminum", b -> (VatMachineRecipeBuilder) b
                            .require(TFMGItems.BAUXITE_POWDER)
                            .require(TFMGItems.BAUXITE_POWDER)
                            .require(TFMGItems.BAUXITE_POWDER)
                            .require(TFMGItems.BAUXITE_POWDER)
                            .output(TFMGItems.ALUMINUM_INGOT)
                            .output(.5f, TFMGItems.ALUMINUM_NUGGET, 4)
                            .output(.25f, TFMGItems.ALUMINUM_NUGGET, 2)
                            .output(TFMGFluids.CARBON_DIOXIDE.get(), 500)
                            .duration(100)
                            .requiresHeat(HeatCondition.HEATED)
                    , electrolysis()),

            WATER_ELECTROLYSIS = createVatRecipe("water_electrolysis", b -> (VatMachineRecipeBuilder) b
                    .require(water(), 2)
                    .output(hydrogen(), 2)
                    .output(oxygen(), 1)
                    .duration(1)
                    .requiresHeat(HeatCondition.NONE),
                    electrolysis()),

            BRINE_ELECTROLYSIS = createVatRecipe("brine_electrolysis", b -> (VatMachineRecipeBuilder) b
                    .require(brine(), 2)
                    .output(sodiumHydroxide(), 2)
                    .output(hydrogen(), 1)
                    .output(chlorine(), 1)
                    .duration(1)
                    .requiresHeat(HeatCondition.NONE),
                    electrolysis()),

            BRINE_MIXING = createVatRecipe("brine_mixing", b -> (VatMachineRecipeBuilder) b
                    .require(water(), 1000)
                    .require(saltDust())
                    .output(brine(), 1000)
                    .duration(1000)
                    .requiresHeat(HeatCondition.NONE),
                    mixing()),

            SULFUR_COMBUSTION = createVatRecipe("sulfur_combustion", b -> (VatMachineRecipeBuilder) b
                    .require(sulfurDust())
                    .require(oxygen(), 8000)
                    .output(sulfurDioxide(), 8000)
                    .duration(8000)
                    .requiresHeat(HeatCondition.HEATED),
                    mixing()),

            SULFURDIOXIDE_COMBUSTION = createVatRecipe("sulfurdioxide_combustion", b -> (VatMachineRecipeBuilder) b
                    .require(sulfurDioxide(), 2)
                    .require(oxygen(), 1)
                    .output(sulfurTrioxide(), 2)
                    .duration(1)
                    .requiresHeat(HeatCondition.HEATED),
                    mixing()),

            SULFURTRIOXIDE_ABSORPTION = createVatRecipe("sulfurtrioxide_absorption", b -> (VatMachineRecipeBuilder) b
                    .require(sulfurTrioxide(), 1)
                    .require(water(), 1)
                    .output(sulfuricAcid(), 1)
                    .duration(1)
                    .requiresHeat(HeatCondition.NONE),
                    mixing()),

            HYDROGENCHLORINE_COMBUSTION = createVatRecipe("hydrogenchlorine_combustion", b -> (VatMachineRecipeBuilder) b
                    .require(hydrogen(), 1)
                    .require(chlorine(), 1)
                    .output(hydrogenChloride(), 2)
                    .duration(1)
                    .requiresHeat(HeatCondition.HEATED),
                    mixing()),

            HYDROGENCHLORIDE_ABSORPTION = createVatRecipe("hydrogenchloride_absorption", b -> (VatMachineRecipeBuilder) b
                    .require(hydrogenChloride(), 1)
                    .require(water(), 1)
                    .output(hydrochloricAcid(), 1)
                    .duration(1)
                    .requiresHeat(HeatCondition.NONE),
                    mixing()),

            AMMONIA_DISPLACEMENT = createVatRecipe("ammonia_displacement", b -> (VatMachineRecipeBuilder) b
                    .require(salammoniacCrystal())
                    .require(sodiumHydroxide(), 1000)
                    .output(ammonia(), 1000)
                    .output(brine(), 1000)
                    .duration(1000)
                    .requiresHeat(HeatCondition.HEATED),
                    mixing()),

            AMMONIA_OXIDATION = createVatRecipe("ammonia_oxidation", b -> (VatMachineRecipeBuilder) b
                    .require(ammonia(), 4)
                    .require(oxygen(), 5)
                    .output(nitrogenOxide(), 4)
                    .output(water(), 6)
                    .duration(1)
                    .requiresHeat(HeatCondition.SUPERHEATED),
                    mixing()),

            NITROGENOXIDE_OXIDATION = createVatRecipe("nitrogenoxide_oxidation", b -> (VatMachineRecipeBuilder) b
                    .require(nitrogenOxide(), 2)
                    .require(oxygen(), 1)
                    .output(nitrogenDioxide(), 2)
                    .duration(1)
                    .requiresHeat(HeatCondition.NONE),
                    mixing()),

            NITROGENDIOXIDE_ABSORPTION = createVatRecipe("nitrogendioxide_absorption", b -> (VatMachineRecipeBuilder) b
                    .require(nitrogenDioxide(), 3)
                    .require(water(), 1)
                    .output(nitricAcid(), 2)
                    .output(nitrogenOxide(), 1)
                    .duration(1)
                    .requiresHeat(HeatCondition.NONE),
                    mixing());

    /// ////
    public VatRecipeParams electrolysis() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:electrode");
        params.machines.add("tfmg:electrode");
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:steel_vat");
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        return params;
    }

    public VatRecipeParams mixing() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:mixing");
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:steel_vat");
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        return params;
    }

    public VatRecipeParams centrifuge() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:centrifuge");
        return params;
    }

    public VatRecipeParams freezing() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:freezing");
        return params;
    }

    public VatRecipeParams intenseFreezing() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:freezing");
        params.machines.add("tfmg:freezing");
        params.machines.add("tfmg:freezing");
        return params;
    }

    public VatRecipeParams arcBlasting() {
        VatRecipeParams params = new VatRecipeParams();
        params.machines.add("tfmg:graphite_electrode");
        params.machines.add("tfmg:graphite_electrode");
        params.machines.add("tfmg:graphite_electrode");
        params.minSize = 9;
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        return params;
    }
}
