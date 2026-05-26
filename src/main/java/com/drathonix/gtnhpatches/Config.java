package com.drathonix.gtnhpatches;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static Set<String> entityRemovalWhitelist = new HashSet<>();
    public static boolean disableIRLDateLimitationsOnForestryMutations = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);
        String[] s = configuration.getStringList(
            "entity_removal_whitelist",
            Configuration.CATEGORY_GENERAL,
            new String[] { "EntityArrow", "BoltEntity", "EntityPotion" },
            "Entities that can be removed if they have invalid data.");
        entityRemovalWhitelist.clear();
        entityRemovalWhitelist.addAll(Arrays.asList(s));

        disableIRLDateLimitationsOnForestryMutations = configuration.getBoolean(
            "disable_irl_date_limitations_on_forestry_mutations",
            Configuration.CATEGORY_GENERAL,
            true,
            "Disables bee/tree/butterfly breeding limitations based on the real life date. Get your Chad bees!");
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
