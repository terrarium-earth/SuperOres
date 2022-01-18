package abused_master.superores.api.ore;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Optional;

public record OreConfig(String name, boolean hasDeepslate, OreProperties oreProperties, OreDrop oreDrop, SpawnRate spawnRate, Optional<OreTextureData> textureData) {

    public static final Codec<OreConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("name").forGetter(OreConfig::name),
            Codec.BOOL.fieldOf("hasDeepslate").orElse(false).forGetter(OreConfig::hasDeepslate),
            OreProperties.CODEC.fieldOf("properties").orElse(new OreProperties()).forGetter(OreConfig::oreProperties),
            OreDrop.CODEC.fieldOf("drops").forGetter(OreConfig::oreDrop),
            SpawnRate.CODEC.fieldOf("spawnRate").orElse(new SpawnRate()).forGetter(OreConfig::spawnRate),
            OreTextureData.CODEC.optionalFieldOf("texture").forGetter(OreConfig::textureData)
    ).apply(instance, OreConfig::new));
}
