package abused_master.superores.blocks;

import abused_master.superores.SuperOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BaseOresBlock extends Block {

    public Item item;
    public int quantityMax;

    public BaseOresBlock(String name, float hardness, int hardnessLevel, Item drops, int quantityMax) {
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
        return this.item;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1 + random.nextInt(quantityMax);
    }
}
