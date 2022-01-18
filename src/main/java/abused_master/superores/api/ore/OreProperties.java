package abused_master.superores.api.ore;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record OreProperties(float strength, OreBreakTool breakTool) {

    public OreProperties() {
        this(1.0f, OreBreakTool.STONE_PICKAXE);
    }

    public static final Codec<OreProperties> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("strength").orElse(1.0f).forGetter(OreProperties::strength),
            OreBreakTool.CODEC.fieldOf("requiredTool").orElse(OreBreakTool.STONE_PICKAXE).forGetter(OreProperties::breakTool)
    ).apply(instance, OreProperties::new));
}
