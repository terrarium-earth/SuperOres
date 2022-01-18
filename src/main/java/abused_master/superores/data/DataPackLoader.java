package abused_master.superores.data;

import abused_master.superores.SuperOres;
import abused_master.superores.api.ore.OreBreakTool;
import abused_master.superores.block.OreEntry;
import abused_master.superores.registry.ModBlocks;
import net.minecraft.SharedConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraft.tags.Tag;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DataPackLoader implements RepositorySource {

    private static final String DATAPACK_NAME = "superores:internal";
    public static final DataPackLoader INSTANCE = new DataPackLoader();

    @Override
    public void loadPacks(@NotNull Consumer<Pack> consumer, @NotNull Pack.PackConstructor constructor) {
        try (MemoryDataPack dataPack = new MemoryDataPack()) {
            Map<OreBreakTool, Tag.Builder> toolBuilders = Arrays.stream(OreBreakTool.values())
                    .collect(Collectors.toMap(breakTool -> breakTool, breakTool -> Tag.Builder.tag()));
            Tag.Builder mineables = Tag.Builder.tag();

            for (OreEntry oreEntry : ModBlocks.ORES.values()) {
                if (oreEntry.getOreBlock().getRegistryName() != null) {
                    ResourceLocation id = oreEntry.getOreBlock().getRegistryName();
                    mineables.addElement(id, DATAPACK_NAME);
                    toolBuilders.get(oreEntry.getConfig().oreProperties().breakTool()).addElement(id, DATAPACK_NAME);
                }

                if (oreEntry.getDeepslateOreBlock() != null && oreEntry.getDeepslateOreBlock().getRegistryName() != null) {
                    ResourceLocation id = oreEntry.getDeepslateOreBlock().getRegistryName();
                    mineables.addElement(id, DATAPACK_NAME);
                    toolBuilders.get(oreEntry.getConfig().oreProperties().breakTool()).addElement(id, DATAPACK_NAME);
                }
            }

            for (Map.Entry<OreBreakTool, Tag.Builder> entry : toolBuilders.entrySet()) {
                dataPack.putJson(PackType.SERVER_DATA, entry.getKey().getTagLocation(), entry.getValue().serializeToJson());
            }

            dataPack.putJson(PackType.SERVER_DATA, new ResourceLocation(SuperOres.MODID, "tags/blocks/ores/superores.json"), mineables.serializeToJson());
            consumer.accept(Pack.create(
                    DATAPACK_NAME,
                    true,
                    () -> dataPack,
                    constructor,
                    Pack.Position.BOTTOM,
                    PackSource.BUILT_IN
            ));
        }
    }

    private static class MemoryDataPack extends GenericMemoryPack {

        public MemoryDataPack() {
            super(PackType.SERVER_DATA, DATAPACK_NAME, "{\"pack_format\": " + PackType.SERVER_DATA.getVersion(SharedConstants.getCurrentVersion()) + ", \"description\": \"Data for SuperOres tags.\"}");
        }
    }
}
