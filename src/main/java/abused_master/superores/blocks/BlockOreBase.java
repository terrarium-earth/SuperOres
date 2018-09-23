package abused_master.superores.blocks;

import abused_master.superores.SuperOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

public class BlockOreBase extends Block {

    private int quantityDropped = 0;
    private ItemStack droppedStack = ItemStack.EMPTY;
    private boolean spawnInNether = false;
    private String oreDictName = "";
    private int minHeight = 0;
    private int maxHeight = 0;
    private int oreRate = 0;

    public BlockOreBase(String name, String oreDictionary, float hardness, int hardnessLevel, ItemStack droppedStack, int dropQuantity, int rate, int minHeight, int maxHeight) {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(SuperOres.SuperOresTab);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", hardnessLevel);

        this.quantityDropped = dropQuantity;
        this.droppedStack = droppedStack;
        this.oreDictName = oreDictionary;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.oreRate = rate;
    }

    public BlockOreBase(String name, String oreDictionary, float hardness, int hardnessLevel, ItemStack droppedStack, int dropQuantity, boolean spawnInNether, int rate, int minHeight, int maxHeight) {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(SuperOres.SuperOresTab);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", hardnessLevel);

        this.quantityDropped = dropQuantity;
        this.droppedStack = droppedStack;
        this.spawnInNether = spawnInNether;
        this.oreDictName = oreDictionary;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.oreRate = rate;
    }

    public BlockOreBase(String name, float hardness, int hardnessLevel, String droppedOre, int dropQuantity, int rate, int minHeight, int maxHeight) {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(SuperOres.SuperOresTab);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", hardnessLevel);

        this.quantityDropped = dropQuantity;
        this.droppedStack = OreDictionary.doesOreNameExist(droppedOre) ? OreDictionary.getOres(droppedOre).get(0) : new ItemStack(Blocks.STONE);
        this.oreDictName = droppedOre;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.oreRate = rate;
    }

    public BlockOreBase(String name, float hardness, int hardnessLevel, String droppedOre, int dropQuantity, boolean spawnInNether, int rate, int minHeight, int maxHeight) {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(SuperOres.SuperOresTab);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", hardnessLevel);

        this.quantityDropped = dropQuantity;
        this.droppedStack = OreDictionary.doesOreNameExist(droppedOre) ? OreDictionary.getOres(droppedOre).get(0) : new ItemStack(Blocks.STONE);
        this.spawnInNether = spawnInNether;
        this.oreDictName = droppedOre;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.oreRate = rate;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return droppedStack != ItemStack.EMPTY ? droppedStack.getItem() : Item.getItemFromBlock(Blocks.STONE);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return this.droppedStack.getMetadata();
    }

    @Override
    public int quantityDropped(Random random) {
        int quantity = random.nextInt(quantityDropped);
        return quantity <= 0 ? 3 : quantity + 2;
    }

    public boolean doesSpawnInNether() {
        return spawnInNether;
    }

    public String getOreDictName() {
        return oreDictName;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getOreRate() {
        return oreRate;
    }
}
