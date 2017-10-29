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
    public static int QuartzOreDrop;

    public static int AluminumOreDrop;
    public static int CopperOreDrop;
    public static int LeadOreDrop;
    public static int SilverOreDrop;
    public static int OsmiumOreDrop;
    public static int UraniumOreDrop;
    public static int NickelOreDrop;
    public static int PlatinumOreDrop;
    public static int TinOreDrop;
    public static int ArditeOreDrop;
    public static int CobaltOreDrop;
    public static int IridiumOreDrop;
    public static int YelloriteOreDrop;

    public static int AluminumOreRate;
    public static int CopperOreRate;
    public static int LeadOreRate;
    public static int SilverOreRate;
    public static int OsmiumOreRate;
    public static int UraniumOreRate;
    public static int NickelOreRate;
    public static int PlatinumOreRate;
    public static int TinOreRate;
    public static int ArditeOreRate;
    public static int CobaltOreRate;
    public static int IridiumOreRate;
    public static int YelloriteOreRate;

    public static int DiamondOreRate;
    public static int GoldOreRate;
    public static int IronOreRate;
    public static int CoalOreRate;
    public static int EmeraldOreRate;
    public static int RedstoneOreRate;
    public static int LapisOreRate;
    public static int QuartzOreRate;


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
        config.addCustomCategoryComment(MOD_SUPPORT, "Mod Support");
        config.addCustomCategoryComment(MOD_GENERATION, "World Generation");

        DiamondOreDrop = config.getInt("SuperDiamondDrop", MOD_ORES, 3, 2, 1000, "Set the maximum amount of ores that will drop");
        EmeraldOreDrop = config.getInt("SuperEmeraldDrop", MOD_ORES, 2, 2, 1000, "Set the maximum amount of ores that will drop");
        CoalOreDrop = config.getInt("SuperCoalDrop", MOD_ORES, 5, 2, 1000, "Set the maximum amount of ores that will drop");
        IronOreDrop = config.getInt("SuperIronDrop", MOD_ORES, 4, 2, 1000, "Set the maximum amount of ores that will drop");
        GoldOreDrop = config.getInt("SuperGoldDrop", MOD_ORES, 4, 2, 1000, "Set the maximum amount of ores that will drop");
        RedstoneOreDrop = config.getInt("SuperRedstoneDrop", MOD_ORES, 5, 2, 1000, "Set the maximum amount of ores that will drop");
        LapisOreDrop = config.getInt("SuperLapisDrop", MOD_ORES, 5, 2, 1000, "Set the maximum amount of ores that will drop");
        QuartzOreDrop = config.getInt("SuperQuartzDrop", MOD_ORES, 3, 2, 1000, "Set the maximum amount of ores that will drop");

        DiamondOreRate = config.getInt("SuperDiamondRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");
        EmeraldOreRate = config.getInt("SuperEmeraldRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");
        CoalOreRate = config.getInt("SuperCoalRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");
        IronOreRate = config.getInt("SuperIronRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");
        GoldOreRate = config.getInt("SuperGoldRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");
        RedstoneOreRate = config.getInt("SuperRedstoneRate", MOD_GENERATION, 15, 0, 1000, "set the random spawn chance of the ore");
        LapisOreRate = config.getInt("SuperLapisRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");
        QuartzOreRate = config.getInt("SuperQuartzRate", MOD_GENERATION, 50, 0, 1000, "set the random spawn chance of the ore");

        CopperOreDrop = config.getInt("CopperOreDrop", MOD_SUPPORT, 4, 2, 1000, "Set the maximum amount of ores that will drop");
        CopperOreRate = config.getInt("SuperCopperRate", MOD_GENERATION, 20, 0, 1000, "set the random spawn chance of the ore");

        AluminumOreDrop = config.getInt("AluminumOreDrop", MOD_SUPPORT, 4, 2, 1000, "Set the maximum amount of ores that will drop");
        AluminumOreRate = config.getInt("SuperAluminumRate", MOD_GENERATION, 22, 0, 1000, "set the random spawn chance of the ore");

        LeadOreDrop = config.getInt("LeadOreDrop", MOD_SUPPORT, 4, 2, 1000, "Set the maximum amount of ores that will drop");
        LeadOreRate = config.getInt("SuperLeadRate", MOD_GENERATION, 17, 0, 1000, "set the random spawn chance of the ore");

        NickelOreDrop = config.getInt("NickelOreDrop", MOD_SUPPORT, 4, 2, 1000, "Set the maximum amount of ores that will drop");
        NickelOreRate = config.getInt("SuperNickelRate", MOD_GENERATION, 20, 0, 1000, "set the random spawn chance of the ore");

        OsmiumOreDrop = config.getInt("OsmiumOreDrop", MOD_SUPPORT, 4, 2, 1000, "Set the maximum amount of ores that will drop");
        OsmiumOreRate = config.getInt("SuperOsmiumRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");

        PlatinumOreDrop = config.getInt("PlatinumOreDrop", MOD_SUPPORT, 3, 2, 1000, "Set the maximum amount of ores that will drop");
        PlatinumOreRate = config.getInt("SuperPlatinumRate", MOD_GENERATION, 15, 0, 1000, "set the random spawn chance of the ore");

        TinOreDrop = config.getInt("TinOreDrop", MOD_SUPPORT, 4, 2, 1000, "Set the maximum amount of ores that will drop");
        TinOreRate = config.getInt("SuperTinRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");

        SilverOreDrop = config.getInt("SilverOreDrop", MOD_SUPPORT, 3, 2, 1000, "Set the maximum amount of ores that will drop");
        SilverOreRate = config.getInt("SuperSilverRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");

        UraniumOreDrop = config.getInt("UraniumOreDrop", MOD_SUPPORT, 3, 2, 1000, "Set the maximum amount of ores that will drop");
        UraniumOreRate = config.getInt("SuperUraniumRate", MOD_GENERATION, 15, 0, 1000, "set the random spawn chance of the ore");

        ArditeOreDrop = config.getInt("ArditeOreDrop", MOD_SUPPORT, 3, 2, 1000, "Set the maximum amount of ores that will drop");
        ArditeOreRate = config.getInt("SuperArditeRate", MOD_GENERATION, 65, 0, 1000, "set the random spawn chance of the ore");

        CobaltOreDrop = config.getInt("CobaltOreDrop", MOD_SUPPORT, 3, 2, 1000, "Set the maximum amount of ores that will drop");
        CobaltOreRate = config.getInt("SuperCobaltRate", MOD_GENERATION, 65, 0, 1000, "set the random spawn chance of the ore");

        IridiumOreDrop = config.getInt("IridiumOreDrop", MOD_SUPPORT, 2, 2, 1000, "Set the maximum amount of ores that will drop");
        IridiumOreRate = config.getInt("SuperIridiumRate", MOD_GENERATION, 8, 0, 1000, "set the random spawn chance of the ore");

        YelloriteOreDrop = config.getInt("YelloriteOreDrop", MOD_SUPPORT, 3, 2, 1000, "Set the maximum amount of ores that will drop");
        YelloriteOreRate = config.getInt("SuperYelloriteRate", MOD_GENERATION, 18, 0, 1000, "set the random spawn chance of the ore");
    }
}
