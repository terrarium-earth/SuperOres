package abused_master.superores.api.ore;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;

public enum OreBreakTool {
    WOOD_PICKAXE(new ResourceLocation("forge", "tags/blocks/needs_wood_tool.json")),
    STONE_PICKAXE(new ResourceLocation("tags/blocks/needs_stone_tool.json")),
    IRON_PICKAXE(new ResourceLocation("tags/blocks/needs_iron_tool.json")),
    GOLD_PICKAXE(new ResourceLocation("forge", "tags/blocks/needs_gold_tool.json")),
    DIAMOND_PICKAXE(new ResourceLocation("tags/blocks/needs_diamond_tool.json")),
    NETHERITE_PICKAXE(new ResourceLocation("forge", "tags/blocks/needs_netherite_tool.json"));

    public static final Codec<OreBreakTool> CODEC = Codec.STRING.xmap(s -> OreBreakTool.valueOf(s.toUpperCase(Locale.ROOT)), OreBreakTool::toString);

    private final ResourceLocation tagLocation;

    OreBreakTool(ResourceLocation tagLocation) {
        this.tagLocation = tagLocation;
    }

    public ResourceLocation getTagLocation() {
        return tagLocation;
    }
}
