package abused_master.superores.registry;

import abused_master.superores.Config;
import abused_master.superores.blocks.ModdedResources;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

public class SuperOresGeneration implements IWorldGenerator {

    private WorldGenerator DiamondOre;
    private WorldGenerator EmeraldOre;
    private WorldGenerator IronOre;
    private WorldGenerator GoldOre;
    private WorldGenerator CoalOre;
    private WorldGenerator RedstoneOre;
    private WorldGenerator LapisOre;
    private WorldGenerator QuartzOre;

    private WorldGenerator AluminumOre;
    private WorldGenerator CopperOre;
    private WorldGenerator SilverOre;
    private WorldGenerator NickelOre;
    private WorldGenerator LeadOre;
    private WorldGenerator UraniumOre;
    private WorldGenerator OsmiumOre;
    private WorldGenerator PlatinumOre;
    private WorldGenerator TinOre;
    private WorldGenerator ArditeOre;
    private WorldGenerator CobaltOre;
    private WorldGenerator IridiumOre;
    private WorldGenerator YelloriteOre;


    public SuperOresGeneration() {
        this.AluminumOre = new WorldGenMinable(ModBlocks.AluminumOre.getDefaultState(), 3);
        this.CopperOre = new WorldGenMinable(ModBlocks.CopperOre.getDefaultState(), 3);
        this.SilverOre = new WorldGenMinable(ModBlocks.SilverOre.getDefaultState(), 3);
        this.NickelOre = new WorldGenMinable(ModBlocks.NickelOre.getDefaultState(), 3);
        this.LeadOre = new WorldGenMinable(ModBlocks.LeadOre.getDefaultState(), 4);
        this.UraniumOre = new WorldGenMinable(ModBlocks.UraniumOre.getDefaultState(), 3);
        this.OsmiumOre = new WorldGenMinable(ModBlocks.OsmiumOre.getDefaultState(), 3);
        this.PlatinumOre = new WorldGenMinable(ModBlocks.PlatinumOre.getDefaultState(), 3);
        this.TinOre = new WorldGenMinable(ModBlocks.TinOre.getDefaultState(), 3);
        this.ArditeOre = new WorldGenMinable(ModBlocks.ArditeOre.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.NETHERRACK));
        this.CobaltOre = new WorldGenMinable(ModBlocks.CobaltOre.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.NETHERRACK));
        this.IridiumOre = new WorldGenMinable(ModBlocks.IridiumOre.getDefaultState(), 3);
        this.YelloriteOre = new WorldGenMinable(ModBlocks.YelloriteOre.getDefaultState(), 3);

        this.DiamondOre = new WorldGenMinable(ModBlocks.DiamondOre.getDefaultState(), 2);
        this.EmeraldOre = new WorldGenMinable(ModBlocks.EmeraldOre.getDefaultState(), 2);
        this.IronOre = new WorldGenMinable(ModBlocks.IronOre.getDefaultState(), 3);
        this.GoldOre = new WorldGenMinable(ModBlocks.GoldOre.getDefaultState(), 3);
        this.CoalOre = new WorldGenMinable(ModBlocks.CoalOre.getDefaultState(), 4);
        this.RedstoneOre = new WorldGenMinable(ModBlocks.RedstoneOre.getDefaultState(), 3);
        this.LapisOre = new WorldGenMinable(ModBlocks.LapisOre.getDefaultState(), 3);
        this.QuartzOre = new WorldGenMinable(ModBlocks.QuartzOre.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.NETHERRACK));
    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {

        switch (world.provider.getDimension()) {
            case 0: //Overworld
                this.runGenerator(this.DiamondOre, world, random, chunkX, chunkZ, Config.DiamondOreRate, 0, 25);
                this.runGenerator(this.EmeraldOre, world, random, chunkX, chunkZ, Config.EmeraldOreRate, 0, 25);
                this.runGenerator(this.IronOre, world, random, chunkX, chunkZ, Config.IronOreRate, 0, 64);
                this.runGenerator(this.GoldOre, world, random, chunkX, chunkZ, Config.GoldOreRate, 0, 35);
                this.runGenerator(this.CoalOre, world, random, chunkX, chunkZ, Config.CoalOreRate, 0, 256);
                this.runGenerator(this.RedstoneOre, world, random, chunkX, chunkZ, Config.RedstoneOreRate, 0, 40);
                this.runGenerator(this.LapisOre, world, random, chunkX, chunkZ, Config.LapisOreRate, 0, 256);

                if(ModdedResources.Copper.doesOreExist()) {
                    this.runGenerator(this.CopperOre, world, random, chunkX, chunkZ, Config.CopperOreRate, 0, 64);
                }

                if(ModdedResources.Aluminum.doesOreExist()) {
                    this.runGenerator(this.AluminumOre, world, random, chunkX, chunkZ, Config.AluminumOreRate, 0, 64);
                }

                if(ModdedResources.Lead.doesOreExist()) {
                    this.runGenerator(this.LeadOre, world, random, chunkX, chunkZ, Config.LeadOreRate, 0, 50);
                }

                if(ModdedResources.Nickel.doesOreExist()) {
                    this.runGenerator(this.NickelOre, world, random, chunkX, chunkZ, Config.NickelOreRate, 0, 50);
                }

                if(ModdedResources.Osmium.doesOreExist()) {
                    this.runGenerator(this.OsmiumOre, world, random, chunkX, chunkZ, Config.OsmiumOreRate, 0, 40);
                }

                if(ModdedResources.Silver.doesOreExist()) {
                    this.runGenerator(this.SilverOre, world, random, chunkX, chunkZ, Config.SilverOreRate, 0, 35);
                }

                if(ModdedResources.Uranium.doesOreExist()) {
                    this.runGenerator(this.UraniumOre, world, random, chunkX, chunkZ, Config.UraniumOreRate, 0, 25);
                }

                if(ModdedResources.Platinum.doesOreExist()) {
                    this.runGenerator(this.PlatinumOre, world, random, chunkX, chunkZ, Config.PlatinumOreRate, 0, 25);
                }

                if(ModdedResources.Tin.doesOreExist()) {
                    this.runGenerator(this.TinOre, world, random, chunkX, chunkZ, Config.TinOreRate, 0, 50);
                }

                if(ModdedResources.Iridium.doesOreExist()) {
                    this.runGenerator(this.IridiumOre, world, random, chunkX, chunkZ, Config.IridiumOreRate, 0, 25);
                }

                if(ModdedResources.Yellorite.doesOreExist()) {
                    this.runGenerator(this.YelloriteOre, world, random, chunkX, chunkZ, Config.YelloriteOreRate, 0, 50);
                }

                break;
            case -1: //Nether
                this.runGenerator(this.QuartzOre, world, random, chunkX, chunkZ, Config.QuartzOreRate, 0, 256);

                if(ModdedResources.Ardite.doesOreExist()) {
                    this.runGenerator(this.ArditeOre, world, random, chunkX, chunkZ, Config.ArditeOreRate, 0, 256);
                }

                if(ModdedResources.Cobalt.doesOreExist()) {
                    this.runGenerator(this.CobaltOre, world, random, chunkX, chunkZ, Config.CobaltOreRate, 0, 256);
                }

                break;
            case 1: //End

                break;
        }
    }
}
