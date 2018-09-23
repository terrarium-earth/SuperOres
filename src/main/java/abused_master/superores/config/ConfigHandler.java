package abused_master.superores.config;

import abused_master.superores.Info;
import net.minecraftforge.common.config.Config;

@Config(modid = Info.MODID, name = Info.MODID)
public class ConfigHandler {

    @Config.Comment({"Setting any Ore Drop Chance to 0 will disable them from dropping"})

    @Config.Name("Diamond Ore Drop Amount")
    @Config.RangeInt(min = 0)
    public static int DiamondOreDrop = 4;

    @Config.RangeInt(min = 0)
    @Config.Name("Gold Ore Drop Amount")
    public static int GoldOreDrop = 6;

    @Config.RangeInt(min = 0)
    @Config.Name("Iron Ore Drop Amount")
    public static int IronOreDrop = 6;

    @Config.RangeInt(min = 0)
    @Config.Name("Coal Ore Drop Amount")
    public static int CoalOreDrop = 5;

    @Config.RangeInt(min = 0)
    @Config.Name("Emerald Ore Drop Amount")
    public static int EmeraldOreDrop = 4;

    @Config.RangeInt(min = 0)
    @Config.Name("Redstone Ore Drop Amount")
    public static int RedstoneOreDrop = 9;

    @Config.RangeInt(min = 0)
    @Config.Name("Lapis Ore Drop Amount")
    public static int LapisOreDrop = 9;

    @Config.RangeInt(min = 0)
    @Config.Name("Quartz Ore Drop Amount")
    public static int QuartzOreDrop = 5;

    @Config.RangeInt(min = 0)
    @Config.Name("Aluminum Ore Drop Amount")
    public static int AluminumOreDrop  = 5;

    @Config.RangeInt(min = 0)
    @Config.Name("Copper Ore Drop Amount")
    public static int CopperOreDrop = 5;

    @Config.RangeInt(min = 0)
    @Config.Name("Lead Ore Drop Amount")
    public static int LeadOreDrop = 6;

    @Config.RangeInt(min = 0)
    @Config.Name("Silver Ore Drop Amount")
    public static int SilverOreDrop = 5;

    @Config.RangeInt(min = 0)
    @Config.Name("Osmium Ore Drop Amount")
    public static int OsmiumOreDrop = 4;

    @Config.RangeInt(min = 0)
    @Config.Name("Uranium Ore Drop Amount")
    public static int UraniumOreDrop = 5;

    @Config.RangeInt(min = 0)
    @Config.Name("Nickel Ore Drop Amount")
    public static int NickelOreDrop = 6;

    @Config.RangeInt(min = 0)
    @Config.Name("Platinum Ore Drop Amount")
    public static int PlatinumOreDrop = 4;

    @Config.RangeInt(min = 0)
    @Config.Name("Tin Ore Drop Amount")
    public static int TinOreDrop = 4;

    @Config.RangeInt(min = 0)
    @Config.Name("Ardite Ore Drop Amount")
    public static int ArditeOreDrop = 4;

    @Config.RangeInt(min = 0)
    @Config.Name("Cobalt Ore Drop Amount")
    public static int CobaltOreDrop = 3;

    @Config.RangeInt(min = 0)
    @Config.Name("Iridium Ore Drop Amount")
    public static int IridiumOreDrop = 4;

    @Config.RangeInt(min = 0)
    @Config.Name("Yellorite Ore Drop Amount")
    public static int YelloriteOreDrop = 4;

    @Config.RangeInt(min = 0)
    @Config.Name("Certus Ore Drop Amount")
    public static int CertusOreDrop = 6;

    @Config.RangeInt(min = 0)
    @Config.Name("Aluminum Ore Spawn Chance")
    public static int AluminumOreRate = 18;

    @Config.RangeInt(min = 0)
    @Config.Name("Copper Ore Spawn Chance")
    public static int CopperOreRate = 18;

    @Config.RangeInt(min = 0)
    @Config.Name("Lead Ore Spawn Chance")
    public static int LeadOreRate = 17;

    @Config.RangeInt(min = 0)
    @Config.Name("Silver Ore Spawn Chance")
    public static int SilverOreRate = 16;

    @Config.RangeInt(min = 0)
    @Config.Name("Osmium Ore Spawn Chance")
    public static int OsmiumOreRate = 18;

    @Config.RangeInt(min = 0)
    @Config.Name("Uranium Ore Spawn Chance")
    public static int UraniumOreRate = 15;

    @Config.RangeInt(min = 0)
    @Config.Name("Nickel Ore Spawn Chance")
    public static int NickelOreRate = 18;

    @Config.RangeInt(min = 0)
    @Config.Name("Platinum Ore Spawn Chance")
    public static int PlatinumOreRate = 15;

    @Config.RangeInt(min = 0)
    @Config.Name("Tin Ore Spawn Chance")
    public static int TinOreRate = 18;

    @Config.RangeInt(min = 0)
    @Config.Name("Ardite Ore Spawn Chance")
    public static int ArditeOreRate = 65;

    @Config.RangeInt(min = 0)
    @Config.Name("Cobalt Ore Spawn Chance")
    public static int CobaltOreRate = 65;

    @Config.RangeInt(min = 0)
    @Config.Name("Iridium Ore Spawn Chance")
    public static int IridiumOreRate = 8;

    @Config.RangeInt(min = 0)
    @Config.Name("Yellorite Ore Spawn Chance")
    public static int YelloriteOreRate = 20;

    @Config.RangeInt(min = 0)
    @Config.Name("Certus Ore Spawn Chance")
    public static int CertusOreRate = 38;

    @Config.RangeInt(min = 0)
    @Config.Name("Diamond Ore Spawn Chance")
    public static int DiamondOreRate = 12;

    @Config.RangeInt(min = 0)
    @Config.Name("Gold Ore Spawn Chance")
    public static int GoldOreRate = 15;

    @Config.RangeInt(min = 0)
    @Config.Name("Iron Ore Spawn Chance")
    public static int IronOreRate = 24;

    @Config.RangeInt(min = 0)
    @Config.Name("Coal Ore Spawn Chance")
    public static int CoalOreRate = 26;

    @Config.RangeInt(min = 0)
    @Config.Name("Emerald Ore Spawn Chance")
    public static int EmeraldOreRate = 10;

    @Config.RangeInt(min = 0)
    @Config.Name("Redstone Ore Spawn Chance")
    public static int RedstoneOreRate = 12;

    @Config.RangeInt(min = 0)
    @Config.Name("Lapis Ore Spawn Chance")
    public static int LapisOreRate = 14;

    @Config.RangeInt(min = 0)
    @Config.Name("Quartz Ore Spawn Chance")
    public static int QuartzOreRate = 25;
}
