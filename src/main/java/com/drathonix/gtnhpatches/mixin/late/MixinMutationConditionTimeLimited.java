package com.drathonix.gtnhpatches.mixin.late;

import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.drathonix.gtnhpatches.Config;

import forestry.api.core.IClimateProvider;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IGenome;
import forestry.core.genetics.mutations.MutationConditionTimeLimited;

@Mixin(MutationConditionTimeLimited.class)
public class MixinMutationConditionTimeLimited {

    @Inject(method = "getChance", at = @At("HEAD"), cancellable = true, remap = false)
    public void disableIRLDateLimitations(World world, int x, int y, int z, IAllele allele0, IAllele allele1,
        IGenome genome0, IGenome genome1, IClimateProvider climate, CallbackInfoReturnable<Float> cir) {
        if (Config.disableIRLDateLimitationsOnForestryMutations) cir.setReturnValue(1.0F);
    }
}
