package com.drathonix.gtnhpatches;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import net.minecraftforge.common.config.Configuration;

public class Config {
    public static Set<String> entityRemovalWhitelist = new HashSet<>();
    static {
        entityRemovalWhitelist.add("EntityArrow");
    }

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);
        configuration.getStringList("entity_removal_whitelist",Configuration.CATEGORY_GENERAL,entityRemovalWhitelist.toArray(new String[0]),"Entities that can be removed if they have invalid data.");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
