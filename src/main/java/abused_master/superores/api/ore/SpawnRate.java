package abused_master.superores.api.ore;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record SpawnRate(SpawnDimension spawnDimension, int veinSize, int spawnFrequency, int minSpawnY, int maxSpawnY) {

    public SpawnRate(int veinSize, int spawnFrequency, int minSpawnLevel, int maxSpawnLevel) {
        this(SpawnDimension.OVERWORLD, veinSize, spawnFrequency, minSpawnLevel, maxSpawnLevel);
    }

    public SpawnRate() {
        this(SpawnDimension.OVERWORLD, 4, 4, 0, 255);
    }

    public static final Codec<SpawnRate> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            SpawnDimension.CODEC.fieldOf("spawnDimension").orElse(SpawnDimension.OVERWORLD).forGetter(SpawnRate::spawnDimension),
            Codec.INT.fieldOf("veinSize").orElse(4).forGetter(SpawnRate::veinSize),
            Codec.INT.fieldOf("spawnFrequency").orElse(2).forGetter(SpawnRate::spawnFrequency),
            Codec.INT.fieldOf("minSpawnY").orElse(0).forGetter(SpawnRate::minSpawnY),
            Codec.INT.fieldOf("maxSpawnY").orElse(255).forGetter(SpawnRate::maxSpawnY)
    ).apply(instance, SpawnRate::new));
}
