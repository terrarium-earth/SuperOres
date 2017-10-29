package abused_master.superores.registry;

import abused_master.superores.Config;
import abused_master.superores.blocks.BaseOresBlock;
import abused_master.superores.blocks.ModdedResources;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

public class ModBlocks {

    public static BaseOresBlock CoalOre = new BaseOresBlock("super_coal", 1.0f, 0,
            new ItemStack(Blocks.COAL_ORE), Config.CoalOreDrop);

    public static BaseOresBlock IronOre = new BaseOresBlock("super_iron", 1.5f, 1,
            new ItemStack(Blocks.IRON_ORE), Config.IronOreDrop);

    public static BaseOresBlock RedstoneOre = new BaseOresBlock("super_redstone", 1.5f, 1,
            new ItemStack(Blocks.REDSTONE_ORE), Config.RedstoneOreDrop);

    public static BaseOresBlock LapisOre = new BaseOresBlock("super_lapis", 1.0f, 0,
            new ItemStack(Blocks.LAPIS_ORE), Config.LapisOreDrop);

    public static BaseOresBlock GoldOre = new BaseOresBlock("super_gold", 1.3f, 2,
            new ItemStack(Blocks.GOLD_ORE), Config.GoldOreDrop);

    public static BaseOresBlock DiamondOre = new BaseOresBlock("super_diamond", 2.5f, 2,
            new ItemStack(Blocks.DIAMOND_ORE), Config.DiamondOreDrop);

    public static BaseOresBlock EmeraldOre = new BaseOresBlock("super_emerald", 2.5f, 2,
            new ItemStack(Blocks.EMERALD_ORE), Config.EmeraldOreDrop);

    public static BaseOresBlock QuartzOre = new BaseOresBlock("super_quartz", 1.5f, 2,
            new ItemStack(Blocks.QUARTZ_ORE), Config.QuartzOreDrop);

    /**
     * Modded Resources
     */
    public static BaseOresBlock AluminumOre = new BaseOresBlock("super_aluminum", 1.0f, 1,
            ModdedResources.Aluminum.getOreFromDict(), Config.AluminumOreDrop);

    public static BaseOresBlock CopperOre = new BaseOresBlock("super_copper", 1.0f, 1,
            ModdedResources.Copper.getOreFromDict(), Config.CopperOreDrop);

    public static BaseOresBlock LeadOre = new BaseOresBlock("super_lead", 1.2f, 1,
            ModdedResources.Lead.getOreFromDict(), Config.LeadOreDrop);

    public static BaseOresBlock SilverOre = new BaseOresBlock("super_silver", 1.8f, 2,
            ModdedResources.Silver.getOreFromDict(), Config.SilverOreDrop);

    public static BaseOresBlock NickelOre = new BaseOresBlock("super_nickel", 1.2f, 1,
            ModdedResources.Nickel.getOreFromDict(), Config.NickelOreDrop);

    public static BaseOresBlock OsmiumOre = new BaseOresBlock("super_osmium", 1.0f, 1,
            ModdedResources.Osmium.getOreFromDict(), Config.OsmiumOreDrop);

    public static BaseOresBlock UraniumOre = new BaseOresBlock("super_uranium", 2.0f, 2,
            ModdedResources.Uranium.getOreFromDict(), Config.UraniumOreDrop);

    public static BaseOresBlock PlatinumOre = new BaseOresBlock("super_platinum", 2.0f, 2,
            ModdedResources.Platinum.getOreFromDict(), Config.PlatinumOreDrop);

    public static BaseOresBlock TinOre = new BaseOresBlock("super_tin", 1.7f, 1,
            ModdedResources.Tin.getOreFromDict(), Config.TinOreDrop);

    public static BaseOresBlock ArditeOre = new BaseOresBlock("super_ardite", 2.0f, 3,
            ModdedResources.Ardite.getOreFromDict(), Config.ArditeOreDrop);

    public static BaseOresBlock CobaltOre = new BaseOresBlock("super_cobalt", 2.0f, 3,
            ModdedResources.Cobalt.getOreFromDict(), Config.CoalOreDrop);

    public static BaseOresBlock IridiumOre = new BaseOresBlock("super_iridium", 1.7f, 3,
            ModdedResources.Iridium.getOreFromDict(), Config.IridiumOreDrop);

    public static BaseOresBlock YelloriteOre = new BaseOresBlock("super_yellorite", 1.4f, 1,
            ModdedResources.Yellorite.getOreFromDict(), Config.YelloriteOreDrop);


    public static void initModels() {
        reg(CoalOre);
        reg(IronOre);
        reg(RedstoneOre);
        reg(GoldOre);
        reg(DiamondOre);
        reg(EmeraldOre);
        reg(LapisOre);
        reg(QuartzOre);

        reg(CopperOre);
        reg(AluminumOre);
        reg(LeadOre);
        reg(NickelOre);
        reg(OsmiumOre);
        reg(SilverOre);
        reg(UraniumOre);
        reg(PlatinumOre);
        reg(TinOre);
        reg(ArditeOre);
        reg(CobaltOre);
        reg(IridiumOre);
        reg(YelloriteOre);
    }

    public static void reg(Block block) {
        ModelResourceLocation res = new
                ModelResourceLocation(block.getRegistryName().toString(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, res);
    }
}
