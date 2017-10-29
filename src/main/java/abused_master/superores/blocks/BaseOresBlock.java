package abused_master.superores.blocks;

import abused_master.superores.SuperOres;
import abused_master.superores.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

public class BaseOresBlock extends Block {

    public ItemStack item;
    public int quantityMax;

    public BaseOresBlock(String name, float hardness, int hardnessLevel, ItemStack drops, int quantityMax) {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(SuperOres.SuperOresTab);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", hardnessLevel);
        this.item = drops;
        this.quantityMax = quantityMax;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if(this.getDefaultState().getBlock() == ModBlocks.OsmiumOre) {
            return OreDictionary.getOres("oreOsmium").get(0).copy().getItem();
        }else if(this.getDefaultState().getBlock() == ModBlocks.YelloriteOre) {
            return OreDictionary.getOres("oreYellorite").get(0).copy().getItem();
        }else if(this.getDefaultState().getBlock() == ModBlocks.ArditeOre) {
            return OreDictionary.getOres("oreArdite").get(0).copy().getItem();
        }else if(this.getDefaultState().getBlock() == ModBlocks.CobaltOre) {
            return OreDictionary.getOres("oreCobalt").get(0).copy().getItem();
        }else {
            return this.item.getItem();
        }
    }

    @Override
    public int damageDropped(IBlockState state) {
        /**
         * Temporary solution ;(
         */
        if(this.getDefaultState().getBlock() == ModBlocks.OsmiumOre) {
            return OreDictionary.getOres("oreOsmium").get(0).copy().getMetadata();
        }else if(this.getDefaultState().getBlock() == ModBlocks.YelloriteOre) {
            return OreDictionary.getOres("oreYellorite").get(0).copy().getMetadata();
        }else if(this.getDefaultState().getBlock() == ModBlocks.ArditeOre) {
            return OreDictionary.getOres("oreArdite").get(0).copy().getMetadata();
        }else if(this.getDefaultState().getBlock() == ModBlocks.CobaltOre) {
            return OreDictionary.getOres("oreCobalt").get(0).copy().getMetadata();
        }else {
            return this.item.getMetadata();
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return 2 + random.nextInt(quantityMax);
    }
}
