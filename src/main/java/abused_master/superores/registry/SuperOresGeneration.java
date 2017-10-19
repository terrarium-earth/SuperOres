package abused_master.superores.registry;

import abused_master.superores.Config;
import abused_master.superores.blocks.ModdedResources;
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

    public SuperOresGeneration() {
        this.DiamondOre = new WorldGenMinable(ModBlocks.DiamondOre.getDefaultState(), 2);
        this.EmeraldOre = new WorldGenMinable(ModBlocks.EmeraldOre.getDefaultState(), 2);
        this.IronOre = new WorldGenMinable(ModBlocks.IronOre.getDefaultState(), 4);
        this.GoldOre = new WorldGenMinable(ModBlocks.GoldOre.getDefaultState(), 3);
        this.CoalOre = new WorldGenMinable(ModBlocks.CoalOre.getDefaultState(), 5);
        this.RedstoneOre = new WorldGenMinable(ModBlocks.RedstoneOre.getDefaultState(), 4);
        this.LapisOre = new WorldGenMinable(ModBlocks.LapisOre.getDefaultState(), 4);
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

                if(OreDictionary.doesOreNameExist(ModdedResources.Copper)) {

                }

                if(OreDictionary.doesOreNameExist(ModdedResources.Aluminum)) {

                }

                if(OreDictionary.doesOreNameExist(ModdedResources.Lead)) {

                }

                if(OreDictionary.doesOreNameExist(ModdedResources.Nickel)) {

                }

                if(OreDictionary.doesOreNameExist(ModdedResources.Osmium)) {

                }

                if(OreDictionary.doesOreNameExist(ModdedResources.Silver)) {

                }

                if(OreDictionary.doesOreNameExist(ModdedResources.Uranium)) {

                }

                if(OreDictionary.doesOreNameExist(ModdedResources.Steel)) {

                }

                break;
            case -1: //Nether

                break;
            case 1: //End

                break;
        }
    }
}
