package abused_master.superores.api.ore;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.awt.*;

public record OreTextureData(String baseTexture, String overlayTexture, boolean hasColor, int color) {

    public OreTextureData(String baseTexture, String overlayTexture, String color) {
        this(
                baseTexture,
                overlayTexture,
                color != null && !color.isEmpty(),
                color != null && !color.isEmpty() ? Color.decode(color).getRGB() : 0xFFFFFF
        );
    }

    public static Codec<OreTextureData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("baseTexture").forGetter(OreTextureData::baseTexture),
            Codec.STRING.fieldOf("overlayTexture").forGetter(OreTextureData::overlayTexture),
            Codec.STRING.fieldOf("overlayColor").orElse("").forGetter(OreTextureData::colorString)
    ).apply(instance, OreTextureData::new));

    public String colorString() {
        return hasColor ? String.format("#%06X", (0xFFFFFF & color)) : "";
    }
}
