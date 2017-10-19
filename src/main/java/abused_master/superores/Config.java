package abused_master.superores;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class Config {

    private static final String MOD_ORES = "Vanilla Ores";
    private static final String MOD_SUPPORT = "Modded Ores";
    private static final String MOD_GENERATION = "Ores Generation";

    public static String configpath;
    public static Configuration config;


    public static int DiamondOreDrop;
    public static int GoldOreDrop;
    public static int IronOreDrop;
    public static int CoalOreDrop;
    public static int EmeraldOreDrop;
    public static int RedstoneOreDrop;
    public static int LapisOreDrop;

    public static int AluminumOreDrop;
    public static int CopperOreDrop;
    public static int LeadOreDrop;
    public static int SilverOreDrop;
    public static int OsmiumOreDrop;
    public static int UraniumOreDrop;
    public static int NickelOreDrop;

    public static int AluminumOreRate;
    public static int CopperOreRate;
    public static int LeadOreRate;
    public static int SilverOreRate;
    public static int OsmiumOreRate;
    public static int UraniumOreRate;
    public static int NickelOreRate;

    public static int DiamondOreRate;
    public static int GoldOreRate;
    public static int IronOreRate;
    public static int CoalOreRate;
    public static int EmeraldOreRate;
    public static int RedstoneOreRate;
    public static int LapisOreRate;


    public static void init(FMLPreInitializationEvent event) {

        configpath = event.getModConfigurationDirectory().getAbsolutePath() + File.separator;
        config = new Configuration(new File(configpath + "SuperOres.cfg"));
        try {
            config.load();
            Config.configure(config);
        } catch (Exception e1) {
            System.out.println("Error Loading Config File: SuperOres.cfg");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    public static void configure(Configuration config) {
        config.addCustomCategoryComment(MOD_ORES, "Super Ores Mod Ores");
        DiamondOreDrop = config.getInt("SuperDiamondDrop", MOD_ORES, 3, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        EmeraldOreDrop = config.getInt("SuperEmeraldDrop", MOD_ORES, 2, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        CoalOreDrop = config.getInt("SuperCoalDrop", MOD_ORES, 5, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        IronOreDrop = config.getInt("SuperIronDrop", MOD_ORES, 4, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        GoldOreDrop = config.getInt("SuperGoldDrop", MOD_ORES, 4, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        RedstoneOreDrop = config.getInt("SuperRedstoneDrop", MOD_ORES, 5, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        LapisOreDrop = config.getInt("SuperLapisDrop", MOD_ORES, 5, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");

        DiamondOreRate = config.getInt("SuperDiamondRate", MOD_ORES, 18, 1, 100, "set the random spawn chance of the ore");
        EmeraldOreRate = config.getInt("SuperEmeraldRate", MOD_ORES, 18, 1, 100, "set the random spawn chance of the ore");
        CoalOreRate = config.getInt("SuperCoalRate", MOD_ORES, 18, 1, 100, "set the random spawn chance of the ore");
        IronOreRate = config.getInt("SuperIronRate", MOD_ORES, 18, 1, 100, "set the random spawn chance of the ore");
        GoldOreRate = config.getInt("SuperGoldRate", MOD_ORES, 18, 1, 100, "set the random spawn chance of the ore");
        RedstoneOreRate = config.getInt("SuperRedstoneRate", MOD_ORES, 15, 1, 100, "set the random spawn chance of the ore");
        LapisOreRate = config.getInt("SuperLapisRate", MOD_ORES, 18, 1, 100, "set the random spawn chance of the ore");

        /**
         * Modded Ores
         */
        config.setCategoryComment(MOD_ORES,"Modded Resources");
        AluminumOreDrop = config.getInt("AluminumOreDrop", MOD_ORES, 5, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        CopperOreDrop = config.getInt("CopperOreDrop", MOD_ORES, 5, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        SilverOreDrop = config.getInt("SilverOreDrop", MOD_ORES, 5, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        LeadOreDrop = config.getInt("LeadOreDrop", MOD_ORES, 5, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        UraniumOreDrop = config.getInt("UraniumOreDrop", MOD_ORES, 4, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        NickelOreDrop = config.getInt("NickelOreDrop", MOD_ORES, 5, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");
        OsmiumOreDrop = config.getInt("OsmiumOreDrop", MOD_ORES, 4, 1, 100, "Set the maximum amount of ores that will drop, minimum = 2");

        /**
         * Worldgen Spawn Rate
         */
        AluminumOreRate = config.getInt("SuperAluminumRate", MOD_ORES, 22, 1, 100, "set the random spawn chance of the ore");
        CopperOreRate = config.getInt("SuperCopperRate", MOD_ORES, 20, 1, 100, "set the random spawn chance of the ore");
        LeadOreRate = config.getInt("SuperLeadRate", MOD_ORES, 17, 1, 100, "set the random spawn chance of the ore");
        SilverOreRate = config.getInt("SuperSilverRate", MOD_ORES, 18, 1, 100, "set the random spawn chance of the ore");
        NickelOreRate = config.getInt("SuperNickelRate", MOD_ORES, 20, 1, 100, "set the random spawn chance of the ore");
        UraniumOreRate = config.getInt("SuperUraniumRate", MOD_ORES, 15, 1, 100, "set the random spawn chance of the ore");
        OsmiumOreRate = config.getInt("SuperOsmiumRate", MOD_ORES, 18, 1, 100, "set the random spawn chance of the ore");

        config.addCustomCategoryComment(MOD_SUPPORT, "Mod Support");
        config.setCategoryComment(MOD_SUPPORT, "Working on it");

        config.addCustomCategoryComment(MOD_GENERATION, "Mod Generation");
        config.setCategoryComment(MOD_GENERATION, "Working on it");
    }
}
