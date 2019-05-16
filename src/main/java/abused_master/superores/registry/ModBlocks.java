package abused_master.superores.registry;

import abused_master.superores.SuperOres;
import abused_master.superores.blocks.BlockOreBase;
import abused_master.superores.blocks.OreGenProperties;
import abused_master.superores.blocks.OreProperties;
import com.google.common.collect.Maps;
import com.google.gson.*;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ModBlocks {

    public static Map<BlockOreBase, OreProperties> orePropertiesMap = Maps.newHashMap();

    public static void register() {
        if(SuperOres.configFile.exists()) {
            loadConfigFile();
        }else {
            registerOre("super_aluminum_ore", 1.5f, 1, 4, "c:aluminum_ore", 4, 1, 30, true);
            registerOre("super_coal_ore", 1.2f, 1, 6, "minecraft:coal_ore", 4, 1, 128, true);
            registerOre("super_copper_ore", 1.4f, 1, 4, "c:copper_ore", 4, 1, 50, true);
            registerOre("super_diamond_ore", 3, 3, 3, "minecraft:diamond_ore", 2, 1, 12, true);
            registerOre("super_emerald_ore", 3, 3, 3, "minecraft:emerald_ore", 2, 1, 12, true);
            registerOre("super_gold_ore", 2, 2, 4, "minecraft:gold_ore", 3, 1, 25, true);
            registerOre("super_iron_ore", 1.5f, 1, 5, "minecraft:iron_ore", 4, 1, 64, true);
            registerOre("super_lapis_ore", 1.8f, 1, 6, "minecraft:lapis_ore", 4, 1, 16, true);
            registerOre("super_lead_ore", 1.2f, 1, 4, "c:lead_ore", 4, 1, 30, true);
            registerOre("super_nickel_ore", 1.2f, 1, 4, "c:nickel_ore", 4, 1, 30, true);
            registerOre("super_platinum_ore", 3, 3, 4, "c:platinum_ore", 2, 1, 12, true);
            registerOre("super_quartz_ore", 2, 2, 5, "minecraft:nether_quartz_ore", 2, 1, 20, true);
            registerOre("super_redstone_ore", 2.2f, 2, 5, "minecraft:redstone_ore", 4, 1, 20, true);
            registerOre("super_silver_ore", 1.8f, 2, 4, "c:silver_ore", 4, 1, 30, true);
            registerOre("super_tin_ore", 1.2f, 1, 5, "c:tin_ore", 4, 1, 60, true);
            saveConfigFile();
        }
    }

    public static void registerWorldGen() {
        for (Map.Entry<BlockOreBase, OreProperties> entry : orePropertiesMap.entrySet()) {
            if(entry.getValue().getOreGenProperties().isEnabled()) {
                if(Registry.ITEM.get(new Identifier(entry.getValue().getDroppedBlock())) != Items.AIR ||
                        Registry.BLOCK.get(new Identifier(entry.getValue().getDroppedBlock())) != Blocks.AIR ||
                        (TagRegistry.item(new Identifier(entry.getValue().getDroppedBlock())) != null && !TagRegistry.item(new Identifier(entry.getValue().getDroppedBlock())).values().isEmpty()) ||
                        (TagRegistry.block(new Identifier(entry.getValue().getDroppedBlock())) != null && !TagRegistry.block(new Identifier(entry.getValue().getDroppedBlock())).values().isEmpty())) {
                    generateOre(entry.getKey(), entry.getValue().getOreGenProperties().getSize(), entry.getValue().getOreGenProperties().getCount(), entry.getValue().getOreGenProperties().getMaxHeight());
                }
            }
        }
    }

    public static void generateOre(Block block, int veinSize, int spawnRate, int maxHeight) {
        for (Biome biome : Registry.BIOME) {
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Biome.configureFeature(net.minecraft.world.gen.feature.Feature.ORE, new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, block.getDefaultState(), veinSize), Decorator.COUNT_RANGE, new RangeDecoratorConfig(spawnRate, 0, 0, maxHeight)));
        }
    }

    public static void loadConfigFile() {
        JsonParser parser = new JsonParser();

        try {
            JsonObject config = parser.parse(new FileReader(SuperOres.configFile)).getAsJsonObject();

            for (Map.Entry<String, JsonElement> entry : config.entrySet()) {
                float hardness = entry.getValue().getAsJsonObject().get("hardness").getAsFloat();
                int miningLevel = entry.getValue().getAsJsonObject().get("miningLevel").getAsInt();
                int dropAmount = entry.getValue().getAsJsonObject().get("dropAmountMax").getAsInt();
                String droppedBlock = entry.getValue().getAsJsonObject().get("droppedBlock").getAsString();

                int size = entry.getValue().getAsJsonObject().get("size").getAsInt();
                int count = entry.getValue().getAsJsonObject().get("count").getAsInt();
                int maxHeight = entry.getValue().getAsJsonObject().get("maxHeight").getAsInt();
                boolean enabled = entry.getValue().getAsJsonObject().get("enabled").getAsBoolean();

                registerOre(entry.getKey(), hardness, miningLevel, dropAmount, droppedBlock, size, count, maxHeight, enabled);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveConfigFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(SuperOres.configFile)){
            JsonObject config = new JsonObject();

            for (Map.Entry<BlockOreBase, OreProperties> entry : orePropertiesMap.entrySet()) {
                JsonObject entryObj = new JsonObject();
                entryObj.addProperty("droppedBlock", entry.getValue().getDroppedBlock());
                entryObj.addProperty("dropAmountMax", entry.getValue().getDropAmount());
                entryObj.addProperty("hardness", entry.getValue().getHardness());
                entryObj.addProperty("miningLevel", entry.getValue().getMiningLevel());

                entryObj.addProperty("size", entry.getValue().getOreGenProperties().getSize());
                entryObj.addProperty("count", entry.getValue().getOreGenProperties().getCount());
                entryObj.addProperty("maxHeight", entry.getValue().getOreGenProperties().getMaxHeight());
                entryObj.addProperty("enabled", entry.getValue().getOreGenProperties().isEnabled());

                config.add(entry.getValue().getName(), entryObj);
            }

            gson.toJson(config, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerOre(String name, float hardness, int miningLevel, int dropAmount, String droppedBlock, int size, int count, int maxHeight, boolean enabled) {
        OreProperties properties = new OreProperties(name, hardness, miningLevel, dropAmount, droppedBlock, new OreGenProperties(size, count, maxHeight, enabled));
        BlockOreBase block = new BlockOreBase(properties);
        orePropertiesMap.put(block, properties);
        Registry.register(Registry.BLOCK, new Identifier(SuperOres.MODID, name), block);
        Registry.register(Registry.ITEM, new Identifier(SuperOres.MODID, name), new BlockItem(block, new Item.Settings().itemGroup(SuperOres.modItemGroup)));
    }
}
