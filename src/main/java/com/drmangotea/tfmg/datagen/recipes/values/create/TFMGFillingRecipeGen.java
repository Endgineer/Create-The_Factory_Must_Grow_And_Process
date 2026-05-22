package com.drmangotea.tfmg.datagen.recipes.values.create;

import com.drmangotea.tfmg.content.items.weapons.fire_extinguisher.FireExtinguisherItem;
import com.drmangotea.tfmg.datagen.recipes.TFMGProcessingRecipeGen;
import com.drmangotea.tfmg.registry.TFMGBlocks;
import com.drmangotea.tfmg.registry.TFMGFluids;
import com.drmangotea.tfmg.registry.TFMGItems;
import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.air;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.airTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.blastFurnaceGas;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.carbonDioxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.carbonDioxideTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.ethylene;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.ethyleneTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.furnaceGasTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hotAir;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hotAirTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hydrogen;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hydrogenTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.lpg;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.lpgTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.neon;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.neonTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.propylene;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.propyleneTank;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.oxygenTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.chlorineTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sulfurDioxideTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sulfurTrioxideTank;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hydrogenChlorideTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.nitrogenOxideTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.nitrogenDioxideTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.ammoniaTank;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.brineTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sodiumHydroxideTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sulfuricAcidTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hydrochloricAcidTank;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.nitricAcidTank;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.oxygen;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.chlorine;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sulfurDioxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sulfurTrioxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hydrogenChloride;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.nitrogenOxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.nitrogenDioxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.ammonia;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.brine;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sodiumHydroxide;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.sulfuricAcid;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.hydrochloricAcid;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.nitricAcid;


public class TFMGFillingRecipeGen extends TFMGProcessingRecipeGen {

    GeneratedRecipe

            HARDENED_PLANKS = create("hardened_planks", b -> b
            .require(ItemTags.PLANKS)
            .require(TFMGFluids.CREOSOTE.getSource(), 250)
            .output(TFMGBlocks.HARDENED_PLANKS)),

    NAPALM_POTATO = create("napalm_potato", b -> b
            .require(Items.POTATO)
            .require(TFMGFluids.NAPALM.getSource(), 500)
            .output(TFMGItems.NAPALM_POTATO)),


    //GAS TANKS

    LPG_TANK = create("lpg_tank", b -> b
            .require(Items.BUCKET)
            .require(lpg(), 1000)
            .output(lpgTank())
    ),
            //BUTANE_TANK = create("butane_tank", b -> b
            //        .require(butane(), 1000)
            //        .output(butaneTank())
            //),
            //PROPANE_TANK = create("propane_tank", b -> b
            //        .require(propane(), 1000)
            //        .output(propaneTank())
            //),
            HYDROGEN_TANK = create("hydrogen_tank", b -> b
                    .require(Items.BUCKET)
                    .require(hydrogen(), 1000)
                    .output(hydrogenTank())
            ),
            FURNACE_GAS_TANK = create("furnace_gas_tank", b -> b
                    .require(Items.BUCKET)
                    .require(blastFurnaceGas(), 1000)
                    .output(furnaceGasTank())
            ),
            ETHYLENE_TANK = create("ethylene_tank", b -> b
                    .require(Items.BUCKET)
                    .require(ethylene(), 1000)
                    .output(ethyleneTank())
            ),
            PROPYLENE_TANK = create("propylene_tank", b -> b
                    .require(Items.BUCKET)
                    .require(propylene(), 1000)
                    .output(propyleneTank())
            ),
            NEON_TANK = create("neon_tank", b -> b
                    .require(Items.BUCKET)
                    .require(neon(), 1000)
                    .output(neonTank())
            ),
            CARBON_DIOXIDE_TANK = create("carbon_dioxide_tank", b -> b
                    .require(Items.BUCKET)
                    .require(carbonDioxide(), 1000)
                    .output(carbonDioxideTank())
            ),
            AIR_TANK = create("air_tank", b -> b
                    .require(Items.BUCKET)
                    .require(air(), 1000)
                    .output(airTank())
            ),
            HOT_AIR_TANK = create("hot_air_tank", b -> b
                    .require(Items.BUCKET)
                    .require(hotAir(), 1000)
                    .output(hotAirTank())
            ),

            FILLED_FIRE_EXTINGUISHER = create("filled_fire_extinguisher", b -> b
                    .require(TFMGItems.FIRE_EXTINGUISHER)
                    .require(carbonDioxide(), 1000)
                    .output(createFilledExtinguisherStack())
            ),

            OXYGEN_TANK = create("oxygen_tank", b -> b.require(Items.BUCKET).require(oxygen(), 1000).output(oxygenTank())),
            CHLORINE_TANK = create("chlorine_tank", b -> b.require(Items.BUCKET).require(chlorine(), 1000).output(chlorineTank())),
            SULFUR_DIOXIDE_TANK = create("sulfur_dioxide_tank", b -> b.require(Items.BUCKET).require(sulfurDioxide(), 1000).output(sulfurDioxideTank())),
            SULFUR_TRIOXIDE_TANK = create("sulfur_trioxide_tank", b -> b.require(Items.BUCKET).require(sulfurTrioxide(), 1000).output(sulfurTrioxideTank())),
            HYDROGEN_CHLORIDE_TANK = create("hydrogen_chloride_tank", b -> b.require(Items.BUCKET).require(hydrogenChloride(), 1000).output(hydrogenChlorideTank())),
            NITROGEN_OXIDE_TANK = create("nitrogen_oxide_tank", b -> b.require(Items.BUCKET).require(nitrogenOxide(), 1000).output(nitrogenOxideTank())),
            NITROGEN_DIOXIDE_TANK = create("nitrogen_dioxide_tank", b -> b.require(Items.BUCKET).require(nitrogenDioxide(), 1000).output(nitrogenDioxideTank())),
            AMMONIA_TANK = create("ammonia_tank", b -> b.require(Items.BUCKET).require(ammonia(), 1000).output(ammoniaTank())),
            BRINE_TANK = create("brine_tank", b -> b.require(Items.BUCKET).require(brine(), 1000).output(brineTank())),
            SODIUM_HYDROXIDE_TANK = create("sodium_hydroxide_tank", b -> b.require(Items.BUCKET).require(sodiumHydroxide(), 1000).output(sodiumHydroxideTank())),
            SULFURIC_ACID_TANK = create("sulfuric_acid_tank", b -> b.require(Items.BUCKET).require(sulfuricAcid(), 1000).output(sulfuricAcidTank())),
            HYDROCHLORIC_ACID_TANK = create("hydrochloric_acid_tank", b -> b.require(Items.BUCKET).require(hydrochloricAcid(), 1000).output(hydrochloricAcidTank())),
            NITRIC_ACID_TANK = create("nitric_acid_tank", b -> b.require(Items.BUCKET).require(nitricAcid(), 1000).output(nitricAcidTank()));

    // Helper method to create the filled extinguisher ItemStack
    private static ItemStack createFilledExtinguisherStack() {
        ItemStack stack = new ItemStack(TFMGItems.FIRE_EXTINGUISHER.get());
        stack.getOrCreateTag().putInt("fill_level", FireExtinguisherItem.DRY_ICE_CAPACITY);
        return stack;
    }

    public TFMGFillingRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.FILLING;
    }

}
