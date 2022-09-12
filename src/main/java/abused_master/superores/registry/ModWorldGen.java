package abused_master.superores.registry;

import abused_master.superores.api.ore.OreConfig;
import abused_master.superores.api.ore.SpawnRate;
import abused_master.superores.block.OreEntry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.ArrayList;
import java.util.List;

public class ModWorldGen {

    public static final RuleTest END_ORE_REPLACEABLES = new TagMatchTest(Tags.Blocks.END_STONES);
    private static final List<Holder<PlacedFeature>> OVERWORLD = new ArrayList<>();
    private static final List<Holder<PlacedFeature>> NETHER = new ArrayList<>();
    private static final List<Holder<PlacedFeature>> END = new ArrayList<>();

    public static void init() {
        for (OreEntry oreEntry : ModBlocks.ORES.values()) {
            OreConfig oreConfig = oreEntry.getConfig();
            String name = oreConfig.name() + "_feature";
            List<OreConfiguration.TargetBlockState> targetList = new ArrayList<>();

            switch (oreConfig.spawnRate().spawnDimension()) {
                case OVERWORLD -> {
                    targetList.add(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, oreEntry.getOreBlock().defaultBlockState()));

                    if (oreEntry.getDeepslateOreBlock() != null)
                        targetList.add(OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, oreEntry.getDeepslateOreBlock().defaultBlockState()));

                    registerFeature(name, OVERWORLD, oreConfig, targetList, oreConfig.spawnRate());
                }
                case NETHER -> {
                    targetList.add(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, oreEntry.getOreBlock().defaultBlockState()));
                    registerFeature(name, NETHER, oreConfig, targetList, oreConfig.spawnRate());
                }
                case END -> {
                    targetList.add(OreConfiguration.target(END_ORE_REPLACEABLES, oreEntry.getOreBlock().defaultBlockState()));
                    registerFeature(name, END, oreConfig, targetList, oreConfig.spawnRate());
                }
            }
        }
    }

    public static void onBiomeLoad(BiomeLoadingEvent event) {
        switch (event.getCategory()) {
            case NETHER -> NETHER.forEach(feature -> addToBiome(feature, event));
            case THEEND -> END.forEach(feature -> addToBiome(feature, event));
            default -> OVERWORLD.forEach(feature -> addToBiome(feature, event));
        }
    }

    public static void addToBiome(Holder<PlacedFeature> feature, BiomeLoadingEvent event) {
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, feature);
    }

    private static void registerFeature(String name, List<Holder<PlacedFeature>> target, OreConfig oreConfig, List<OreConfiguration.TargetBlockState> targetList, SpawnRate spawnRate) {
        Holder<ConfiguredFeature<OreConfiguration, ?>> configuredFeature = FeatureUtils.register(name, Feature.ORE, new OreConfiguration(targetList, oreConfig.spawnRate().veinSize()));
        Holder<PlacedFeature> placedFeature = PlacementUtils.register(name, configuredFeature, CountPlacement.of(oreConfig.spawnRate().spawnFrequency()),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.triangle(
                        VerticalAnchor.absolute(oreConfig.spawnRate().minSpawnY()),
                        VerticalAnchor.absolute(oreConfig.spawnRate().maxSpawnY())
                ));

        target.add(placedFeature);
    }
}
