package abused_master.superores.registry;

import abused_master.superores.SuperOres;
import abused_master.superores.api.ore.OreConfig;
import abused_master.superores.block.OreEntry;
import abused_master.superores.block.SuperOreBlock;
import abused_master.superores.client.ModResources;
import abused_master.superores.config.CommonConfig;
import abused_master.superores.utils.FileUtils;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.text.WordUtils;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ModBlocks {

    public static final CreativeModeTab TAB = new CreativeModeTab("superores") {
        @Override
        @NotNull
        public ItemStack makeIcon() {
            return Items.DIAMOND_PICKAXE.getDefaultInstance();
        }
    };
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperOres.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperOres.MODID);
    public static final Map<String, OreEntry> ORES = new HashMap<>();
    public static final Map<String, String> LANG_TABLE = new HashMap<>();

    public static final TagKey<Block> SUPER_ORES = BlockTags.create(new ResourceLocation(SuperOres.MODID, "ores/superores"));

    public static void init() {
        Path path = FMLPaths.CONFIGDIR.get().resolve("superores/ores");
        if (CommonConfig.GENERATE_DEFAULTS.get()) {
            FileUtils.setupDefaultFiles("/data/superores/defaults", path);
        }

        FileUtils.streamFilesAndParse(path, ModBlocks::parseOre, "Could not stream custom Super Ores!");
    }

    private static void parseOre(Reader reader, String name) {
        JsonObject json = SuperOres.GSON.fromJson(reader, JsonObject.class);
        OreConfig config = OreConfig.CODEC.parse(JsonOps.INSTANCE, json).getOrThrow(false, s -> SuperOres.LOGGER.error("Could not create custom Super Ore for {}", s));
        OreEntry entry = new OreEntry(config);

        var oreBlock = BLOCKS.register("super_" + config.name(), () -> new SuperOreBlock(entry));
        ITEMS.register("super_" + config.name(), () -> new BlockItem(oreBlock.get(), new Item.Properties().tab(TAB)));
        entry.setOreBlock(oreBlock);
        addLangEntry(false, config.name());

        if (config.hasDeepslate()) {
            var deepslate = BLOCKS.register("super_deepslate_" + config.name(), () -> new SuperOreBlock(entry, true));
            ITEMS.register("super_deepslate_" + config.name(), () -> new BlockItem(deepslate.get(), new Item.Properties().tab(TAB)));
            entry.setDeepslateOreBlock(deepslate);
            addLangEntry(true, config.name());
        }

        ORES.put(config.name(), entry);
    }

    private static void addLangEntry(boolean isDeepSlate, String configName) {
        String name = (isDeepSlate ? "super_deepslate_" : "super_") + configName;
        LANG_TABLE.put(ModResources.LANG_PREFIX + name, WordUtils.capitalizeFully(name.replaceAll("_", " ")));
    }
}
