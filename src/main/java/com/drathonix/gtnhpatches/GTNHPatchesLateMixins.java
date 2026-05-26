package com.drathonix.gtnhpatches;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class GTNHPatchesLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.dgtnhpatches.late.json";
    }

    @Nonnull
    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> mixins = new ArrayList<>();
        if (loadedMods.contains("Forestry")) {
            mixins.add("MixinMutationConditionTimeLimited");
        }
        return mixins;
    }
}
