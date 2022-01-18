package abused_master.superores.api.ore;

import com.mojang.serialization.Codec;

import java.util.Locale;

public enum SpawnDimension {
    OVERWORLD,
    NETHER,
    END;

    public static final Codec<SpawnDimension> CODEC = Codec.STRING.xmap(s -> SpawnDimension.valueOf(s.toUpperCase(Locale.ROOT)), SpawnDimension::toString);
}
