package abused_master.superores.registry;

import abused_master.superores.blocks.BlockOreBase;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGeneration implements IWorldGenerator {

    public List<BlockOreBase> OVERWORLD = new ArrayList<>();
    public List<BlockOreBase> NETHER = new ArrayList<>();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //Overworld
                for (BlockOreBase ore : OVERWORLD) {
                    this.runGenerator(new WorldGenMinable(ore.getDefaultState(), 3), world, random, chunkX, chunkZ, ore.getOreRate(), ore.getMinHeight(), ore.getMaxHeight());
                }
                break;
            case -1: //Nether
                for (BlockOreBase ore : NETHER) {
                    this.runGenerator(new WorldGenMinable(ore.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.NETHERRACK)), world, random, chunkX, chunkZ, ore.getOreRate(), ore.getMinHeight(), ore.getMaxHeight());
                }
                break;
            case 1: //End
                break;
        }
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
}
