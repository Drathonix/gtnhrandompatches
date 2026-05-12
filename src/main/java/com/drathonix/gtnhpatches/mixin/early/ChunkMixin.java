package com.drathonix.gtnhpatches.mixin.early;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.drathonix.gtnhpatches.Config;
import com.drathonix.gtnhpatches.GTNHPatches;

@Mixin(Chunk.class)
public class ChunkMixin {

    @Shadow
    public World worldObj;

    @Inject(
        method = "addEntity",
        at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;warn(Ljava/lang/String;)V"),
        cancellable = true)
    public void removeInvalidEntities(Entity entity, CallbackInfo ci) {
        if (Config.entityRemovalWhitelist.contains(
            entity.getClass()
                .getSimpleName())) {
            worldObj.removeEntity(entity);
            GTNHPatches.LOG.warn(
                "Removed invalid entity: {}",
                entity.getClass()
                    .getSimpleName());
            ci.cancel();
        }
    }
}
