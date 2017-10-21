package abused_master.superores;

import abused_master.superores.blocks.ModdedResources;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

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
    public static int PlatinumOreDrop;
    public static int TinOreDrop;

    public static int AluminumOreRate;
    public static int CopperOreRate;
    public static int LeadOreRate;
    public static int SilverOreRate;
    public static int OsmiumOreRate;
    public static int UraniumOreRate;
    public static int NickelOreRate;
    public static int PlatinumOreRate;
    public static int TinOreRate;

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
        config.addCustomCategoryComment(MOD_SUPPORT, "Mod Support");
        config.addCustomCategoryComment(MOD_GENERATION, "World Generation");

        DiamondOreDrop = config.getInt("SuperDiamondDrop", MOD_ORES, 3, 2, 100, "Set the maximum amount of ores that will drop");
        EmeraldOreDrop = config.getInt("SuperEmeraldDrop", MOD_ORES, 2, 2, 100, "Set the maximum amount of ores that will drop");
        CoalOreDrop = config.getInt("SuperCoalDrop", MOD_ORES, 5, 2, 100, "Set the maximum amount of ores that will drop");
        IronOreDrop = config.getInt("SuperIronDrop", MOD_ORES, 4, 2, 100, "Set the maximum amount of ores that will drop");
        GoldOreDrop = config.getInt("SuperGoldDrop", MOD_ORES, 4, 2, 100, "Set the maximum amount of ores that will drop");
        RedstoneOreDrop = config.getInt("SuperRedstoneDrop", MOD_ORES, 5, 2, 100, "Set the maximum amount of ores that will drop");
        LapisOreDrop = config.getInt("SuperLapisDrop", MOD_ORES, 5, 2, 100, "Set the maximum amount of ores that will drop");

        DiamondOreRate = config.getInt("SuperDiamondRate", MOD_GENERATION, 18, 0, 100, "set the random spawn chance of the ore");
        EmeraldOreRate = config.getInt("SuperEmeraldRate", MOD_GENERATION, 18, 0, 100, "set the random spawn chance of the ore");
        CoalOreRate = config.getInt("SuperCoalRate", MOD_GENERATION, 18, 0, 100, "set the random spawn chance of the ore");
        IronOreRate = config.getInt("SuperIronRate", MOD_GENERATION, 18, 0, 100, "set the random spawn chance of the ore");
        GoldOreRate = config.getInt("SuperGoldRate", MOD_GENERATION, 18, 0, 100, "set the random spawn chance of the ore");
        RedstoneOreRate = config.getInt("SuperRedstoneRate", MOD_GENERATION, 15, 0, 100, "set the random spawn chance of the ore");
        LapisOreRate = config.getInt("SuperLapisRate", MOD_GENERATION, 18, 0, 100, "set the random spawn chance of the ore");

        if(ModdedResources.Copper.doesOreExist()) {
            CopperOreDrop = config.getInt("CopperOreDrop", MOD_SUPPORT, 4, 2, 100, "Set the maximum amount of ores that will drop");
            CopperOreRate = config.getInt("SuperCopperRate", MOD_GENERATION, 20, 0, 100, "set the random spawn chance of the ore");
        }

        if(ModdedResources.Aluminum.doesOreExist()) {
            AluminumOreDrop = config.getInt("AluminumOreDrop", MOD_SUPPORT, 4, 2, 100, "Set the maximum amount of ores that will drop");
            AluminumOreRate = config.getInt("SuperAluminumRate", MOD_GENERATION, 22, 0, 100, "set the random spawn chance of the ore");
        }

        if(ModdedResources.Lead.doesOreExist()) {
            LeadOreDrop = config.getInt("LeadOreDrop", MOD_SUPPORT, 4, 2, 100, "Set the maximum amount of ores that will drop");
            LeadOreRate = config.getInt("SuperLeadRate", MOD_GENERATION, 17, 0, 100, "set the random spawn chance of the ore");
        }

        if(ModdedResources.Nickel.doesOreExist()) {
            NickelOreDrop = config.getInt("NickelOreDrop", MOD_SUPPORT, 4, 2, 100, "Set the maximum amount of ores that will drop");
            NickelOreRate = config.getInt("SuperNickelRate", MOD_GENERATION, 20, 0, 100, "set the random spawn chance of the ore");
        }

        if(ModdedResources.Osmium.doesOreExist()) {
            OsmiumOreDrop = config.getInt("OsmiumOreDrop", MOD_SUPPORT, 4, 2, 100, "Set the maximum amount of ores that will drop");
            OsmiumOreRate = config.getInt("SuperOsmiumRate", MOD_GENERATION, 18, 0, 100, "set the random spawn chance of the ore");
        }

        //if(ModdedResources.Platinum.doesOreExist()) {
        if(OreDictionary.doesOreNameExist("orePlatinum")) {
            PlatinumOreDrop = config.getInt("PlatinumOreDrop", MOD_SUPPORT, 3, 2, 100, "Set the maximum amount of ores that will drop");
            PlatinumOreRate = config.getInt("SuperPlatinumRate", MOD_GENERATION, 15, 0, 100, "set the random spawn chance of the ore");
        }

        //if(ModdedResources.Tin.doesOreExist()) {
        if(OreDictionary.doesOreNameExist("oreTin")) {
            TinOreDrop = config.getInt("TinOreDrop", MOD_SUPPORT, 4, 2, 100, "Set the maximum amount of ores that will drop");
            TinOreRate = config.getInt("SuperTinRate", MOD_GENERATION, 18, 0, 100, "set the random spawn chance of the ore");
        }

        if(ModdedResources.Silver.doesOreExist()) {
            SilverOreDrop = config.getInt("SilverOreDrop", MOD_SUPPORT, 3, 2, 100, "Set the maximum amount of ores that will drop");
            SilverOreRate = config.getInt("SuperSilverRate", MOD_GENERATION, 18, 0, 100, "set the random spawn chance of the ore");
        }

        if(ModdedResources.Uranium.doesOreExist()) {
            UraniumOreDrop = config.getInt("UraniumOreDrop", MOD_SUPPORT, 3, 2, 100, "Set the maximum amount of ores that will drop");
            UraniumOreRate = config.getInt("SuperUraniumRate", MOD_GENERATION, 15, 0, 100, "set the random spawn chance of the ore");
        }
    }
}
