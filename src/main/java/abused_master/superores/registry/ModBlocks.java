package abused_master.superores.registry;

import abused_master.superores.Config;
import abused_master.superores.blocks.BaseOresBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ModBlocks {

    public static BaseOresBlock CoalOre = new BaseOresBlock("super_coal", 1.0f, 0,
            Item.getItemFromBlock(Blocks.COAL_ORE), Config.CoalOreDrop);

    public static BaseOresBlock IronOre = new BaseOresBlock("super_iron", 1.5f, 1,
            Item.getItemFromBlock(Blocks.IRON_ORE), Config.IronOreDrop);

    public static BaseOresBlock RedstoneOre = new BaseOresBlock("super_redstone", 1.5f, 1,
            Item.getItemFromBlock(Blocks.REDSTONE_ORE), Config.RedstoneOreDrop);

    public static BaseOresBlock LapisOre = new BaseOresBlock("super_lapis", 1.0f, 0,
            Item.getItemFromBlock(Blocks.LAPIS_ORE), Config.LapisOreDrop);

    public static BaseOresBlock GoldOre = new BaseOresBlock("super_gold", 1.3f, 2,
            Item.getItemFromBlock(Blocks.GOLD_ORE), Config.GoldOreDrop);

    public static BaseOresBlock DiamondOre = new BaseOresBlock("super_diamond", 2.5f, 2,
            Item.getItemFromBlock(Blocks.DIAMOND_ORE), Config.DiamondOreDrop);

    public static BaseOresBlock EmeraldOre = new BaseOresBlock("super_emerald", 2.5f, 2,
            Item.getItemFromBlock(Blocks.EMERALD_ORE), Config.EmeraldOreDrop);

    public static void initModels() {
        reg(CoalOre);
        reg(IronOre);
        reg(RedstoneOre);
        reg(GoldOre);
        reg(DiamondOre);
        reg(EmeraldOre);
        reg(LapisOre);
    }

    public static void reg(Block block) {
        ModelResourceLocation res = new
                ModelResourceLocation(block.getRegistryName().toString(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, res);
    }
}
