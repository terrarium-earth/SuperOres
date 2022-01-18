package abused_master.superores.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;

public class CommonConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static BooleanValue GENERATE_DEFAULTS;

    static {
        Builder BUILDER = new Builder();
        BUILDER.push("Super Ores Options");
        GENERATE_DEFAULTS = BUILDER.comment("Set this value to true if you'd like all ore configuration to be re-generated, WARNING: All your previous changes will be reset!")
                .define("generateDefaults", true);
        BUILDER.pop();

        CONFIG_SPEC = BUILDER.build();
    }
}
