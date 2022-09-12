package abused_master.superores.client;

import abused_master.superores.SuperOres;
import abused_master.superores.api.ore.OreTextureData;
import abused_master.superores.block.OreEntry;
import abused_master.superores.config.ClientConfig;
import abused_master.superores.registry.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModClient {

    private static final String MODEL_JSON = """
            {
              "parent": "superores:block/base_ore",
              "textures": {
                "particle": "{particle_texture}",
                "layer0": "{layer0_texture}",
                "layer1": "{layer1_texture}"
              }
            }
            """;

    private static final String BLOCKSTATE_JSON = """
            {
              "variants": {
                "": {
                  "model": "superores:block/{block_model}"
                }
              }
            }
            """;

    private static final String ITEM_JSON = """
            {
              "parent": "superores:block/{parent_model}"
            }
            """;

    public static void init() {
        initModels();

        if (ClientConfig.GENERATE_LANG.get())
            initLang();

        ModResources.init();
    }

    public static void initClient(FMLClientSetupEvent event) {
        Minecraft mc = Minecraft.getInstance();

        for (OreEntry oreEntry : ModBlocks.ORES.values()) {
            oreEntry.getConfig().textureData().ifPresent(textureData -> {
                if (textureData.hasColor()) {
                    mc.getBlockColors().register((state, reader, pos, tintIndex) -> tintIndex == 1 ? textureData.color() : 0xFFFFFF, oreEntry.getOreBlock());
                    mc.getItemColors().register((stack, tintIndex) -> tintIndex == 1 ? textureData.color() : 0xFFFFFF, oreEntry.getOreBlock());

                    if (oreEntry.getDeepslateOreBlock() != null) {
                        mc.getBlockColors().register((state, reader, pos, tintIndex) -> tintIndex == 1 ? textureData.color() : 0xFFFFFF, oreEntry.getDeepslateOreBlock());
                        mc.getItemColors().register((stack, tintIndex) -> tintIndex == 1 ? textureData.color() : 0xFFFFFF, oreEntry.getDeepslateOreBlock());
                    }
                }

                ItemBlockRenderTypes.setRenderLayer(oreEntry.getOreBlock(), RenderType.cutout());
                if (oreEntry.getDeepslateOreBlock() != null)
                    ItemBlockRenderTypes.setRenderLayer(oreEntry.getDeepslateOreBlock(), RenderType.cutout());
            });
        }
    }

    private static void initLang() {
        String json = SuperOres.GSON.toJson(ModBlocks.LANG_TABLE);
        ModResources.writeResource("lang", "en_us.json", json);
    }

    private static void initModels() {
        for (OreEntry oreEntry : ModBlocks.ORES.values()) {
            oreEntry.getConfig().textureData().ifPresent(textureData -> {
                createBlockstate(oreEntry.getConfig().name(), false);
                createModel(oreEntry.getConfig().name(), textureData, false);

                if (oreEntry.getConfig().hasDeepslate()) {
                    createBlockstate(oreEntry.getConfig().name(), true);
                    createModel(oreEntry.getConfig().name(), textureData, true);
                }
            });
        }
    }

    private static void createModel(String name, OreTextureData textureData, boolean isDeepslate) {
        String prefix = (isDeepslate ? "super_deepslate_" : "super_");
        String model = MODEL_JSON.replace("{particle_texture}", textureData.baseTexture())
                .replace("{layer0_texture}", isDeepslate ? "block/deepslate" : textureData.baseTexture())
                .replace("{layer1_texture}", textureData.overlayTexture());
        String itemModel = ITEM_JSON.replace("{parent_model}", prefix + name);

        ModResources.writeResource("models/block", prefix + name + ".json", model);
        ModResources.writeResource("models/item", prefix + name + ".json", itemModel);
    }

    private static void createBlockstate(String name, boolean isDeepslate) {
        String prefix = (isDeepslate ? "super_deepslate_" : "super_");
        String blockstate = BLOCKSTATE_JSON.replace("{block_model}", prefix + name);
        ModResources.writeResource("blockstates", prefix + name + ".json", blockstate);
    }
}
