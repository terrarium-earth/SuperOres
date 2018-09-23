package abused_master.superores.registry;

import abused_master.superores.blocks.BlockOreBase;
import abused_master.superores.config.ConfigHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class ModResources {

    public static List<BlockOreBase> ORES = new ArrayList<>();

    public static void register() {
        register(new BlockOreBase("super_coal", "oreCoal", 1.0f, 0, new ItemStack(Items.COAL), ConfigHandler.CoalOreDrop, ConfigHandler.CoalOreRate, 0, 256));
        register(new BlockOreBase("super_iron", "oreIron", 1.5f, 1, new ItemStack(Blocks.IRON_ORE), ConfigHandler.IronOreDrop, ConfigHandler.IronOreRate, 0, 64));
        register(new BlockOreBase("super_redstone", "oreRedstone", 2.0f, 2, new ItemStack(Items.REDSTONE), ConfigHandler.RedstoneOreDrop, ConfigHandler.RedstoneOreRate, 0, 40));
        register(new BlockOreBase("super_lapis", "oreLapis", 1.5f, 1, new ItemStack(Items.DYE, 1, 4), ConfigHandler.LapisOreDrop, ConfigHandler.LapisOreRate, 0, 256));
        register(new BlockOreBase("super_gold", "oreGold", 1.5f, 2, new ItemStack(Blocks.GOLD_ORE), ConfigHandler.GoldOreDrop, ConfigHandler.GoldOreRate, 0, 35));
        register(new BlockOreBase("super_diamond", "oreDiamond", 2.5f, 2, new ItemStack(Items.DIAMOND), ConfigHandler.DiamondOreDrop, ConfigHandler.DiamondOreRate, 0, 18));
        register(new BlockOreBase("super_emerald", "oreEmerald", 2.5f, 3, new ItemStack(Items.EMERALD), ConfigHandler.EmeraldOreDrop, ConfigHandler.EmeraldOreRate, 0, 18));

        register(new BlockOreBase("super_quartz", "oreQuartz", 1.5f, 2, new ItemStack(Items.QUARTZ), ConfigHandler.QuartzOreDrop, true, ConfigHandler.QuartzOreRate, 0, 256));

        /**
         * Modded Resources
         */
        register(new BlockOreBase("super_aluminum", 1.0f, 1, "oreAluminum", ConfigHandler.AluminumOreDrop, ConfigHandler.AluminumOreRate, 0, 64));
        register(new BlockOreBase("super_copper", 1.0f, 1, "oreCopper", ConfigHandler.CopperOreDrop, ConfigHandler.CopperOreRate, 0, 64));
        register(new BlockOreBase("super_lead", 1.2f, 1, "oreLead", ConfigHandler.LeadOreDrop, ConfigHandler.LeadOreRate, 0, 50));
        register(new BlockOreBase("super_nickel", 1.2f, 1, "oreNickel", ConfigHandler.NickelOreDrop, ConfigHandler.NickelOreRate, 0, 50));
        register(new BlockOreBase("super_osmium", 1.2f, 1, "oreOsmium", ConfigHandler.OsmiumOreDrop, ConfigHandler.OsmiumOreRate, 0, 40));
        register(new BlockOreBase("super_silver", 1.8f, 2, "oreSilver", ConfigHandler.SilverOreDrop, ConfigHandler.SilverOreRate, 0, 35));
        register(new BlockOreBase("super_uranium", 2.0f, 2, "oreUranium", ConfigHandler.UraniumOreDrop, ConfigHandler.UraniumOreRate, 0, 25));
        register(new BlockOreBase("super_platinum", 2.0f, 2, "orePlatinum", ConfigHandler.PlatinumOreDrop, ConfigHandler.PlatinumOreRate, 0, 25));
        register(new BlockOreBase("super_tin", 1.7f, 1, "oreTin", ConfigHandler.TinOreDrop, ConfigHandler.TinOreRate, 0, 50));
        register(new BlockOreBase("super_iridium", 1.7f, 3, "oreIridium", ConfigHandler.IridiumOreDrop, ConfigHandler.IridiumOreRate, 0, 25));
        register(new BlockOreBase("super_yellorite", 1.4f, 1, "oreYellorite", ConfigHandler.YelloriteOreDrop, ConfigHandler.YelloriteOreRate, 0, 50));
        register(new BlockOreBase("super_certus", 1.3f, 1, "oreCertusQuartz", ConfigHandler.CertusOreDrop, ConfigHandler.CertusOreRate, 0, 50));

        register(new BlockOreBase("super_ardite", 2.0f, 3, "oreArdite", ConfigHandler.ArditeOreDrop, true, ConfigHandler.ArditeOreRate, 0, 256));
        register(new BlockOreBase("super_cobalt", 2.0f, 3, "oreCobalt", ConfigHandler.CobaltOreDrop, true, ConfigHandler.CobaltOreRate, 0, 256));
    }

    public static void addWorldGen(WorldGeneration worldGen) {
        for (BlockOreBase ore : ORES) {
            if (OreDictionary.doesOreNameExist(ore.getOreDictName())) {
                if (!ore.doesSpawnInNether())
                    worldGen.OVERWORLD.add(ore);
                else
                    worldGen.NETHER.add(ore);
            }
        }
    }

    public static void register(BlockOreBase block) {
        ORES.add(block);
    }
}
