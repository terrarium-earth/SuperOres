package abused_master.superores.client;

import abused_master.superores.SuperOres;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.FolderPackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ModResources {

    public static String LANG_PREFIX = "block.superores.";

    public static void init() {
        setupPack();
        loadResources();
    }

    private static void setupPack() {
        SuperOres.LOGGER.info("Setting up config paths...");
        Path path = FMLPaths.CONFIGDIR.get().resolve("superores/resources");

        try (FileWriter file = new FileWriter(Paths.get(path.toAbsolutePath().toString(), "pack.mcmeta").toFile())) {
            String mcMetaContent = "{\"pack\":{\"pack_format\":" + PackType.CLIENT_RESOURCES.getVersion(SharedConstants.getCurrentVersion()) + ",\"description\":\"SuperOres resource pack used for lang and custom texture purposes.\"}}";
            file.write(mcMetaContent);
        } catch (IOException e) {
            SuperOres.LOGGER.error("Failed to create pack.mcmeta file for resource loading");
        }
    }

    private static void loadResources() {
        //This is needed for data gen as Minecraft.getInstance() is null in data gen.
        //noinspection ConstantConditions
        if (Minecraft.getInstance() == null) return;
        Path path = FMLPaths.CONFIGDIR.get().resolve("superores/resources");

        Minecraft.getInstance().getResourcePackRepository().addPackFinder((consumer, factory) -> {
            final Pack packInfo = Pack.create(
                    SuperOres.MODID,
                    true,
                    () -> new FolderPackResources(path.toFile()) {
                        @Override
                        public boolean isHidden() {
                            return true;
                        }
                    },
                    factory,
                    Pack.Position.TOP,
                    PackSource.BUILT_IN
            );

            if (packInfo == null) {
                SuperOres.LOGGER.error("Failed to load super ores config resource pack, some things may not work.");
                return;
            }

            consumer.accept(packInfo);
        });
    }

    public static void writeResource(String savePath, String fileName, String data) {
        Path path = FMLPaths.CONFIGDIR.get().resolve("superores/resources/assets/superores/" + savePath);
        try {
            Files.createDirectories(path);
            try (FileWriter writer = new FileWriter(path.resolve(fileName).toFile())) {
                writer.write(data);
            }
        } catch (IOException e) {
            SuperOres.LOGGER.error("Could not generate resource file: {}", fileName);
            e.printStackTrace();
        }
    }
}
