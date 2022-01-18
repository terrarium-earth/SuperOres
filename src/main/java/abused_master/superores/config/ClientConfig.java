package abused_master.superores.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static ForgeConfigSpec.BooleanValue GENERATE_LANG;

    static {
        ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
        BUILDER.push("Super Ores Client Options");
        GENERATE_LANG = BUILDER.comment("Set this value to true if you'd like the lang configuration to be re-generated, WARNING: All your previous changes will be reset!")
                .define("generateLang", true);
        BUILDER.pop();

        CONFIG_SPEC = BUILDER.build();
    }
}
