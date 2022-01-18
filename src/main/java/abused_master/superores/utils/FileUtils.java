package abused_master.superores.utils;

import abused_master.superores.SuperOres;
import net.minecraftforge.fml.ModList;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/**
 * Taken from Resourceful Bees, Thx Gravy <3
 */
public class FileUtils {

    public static final String JSON = ".json";
    public static final Path MOD_ROOT = ModList.get().getModFileById(SuperOres.MODID).getFile().getFilePath();

    public static void streamFilesAndParse(Path directoryPath, BiConsumer<Reader, String> instructions, String errorMessage) {
        try (Stream<Path> jsonStream = Files.walk(directoryPath)) {
            jsonStream.filter(f -> f.getFileName().toString().endsWith(JSON)).forEach(path -> addFile(path, instructions));
        } catch (IOException e) {
            SuperOres.LOGGER.error(errorMessage, e);
        }
    }

    private static void addFile(Path path, BiConsumer<Reader, String> instructions) {
        File f = path.toFile();
        try {
            parseType(f, instructions);
        } catch (IOException e) {
            SuperOres.LOGGER.warn("File not found: {}", path);
        }
    }

    private static void parseType(File file, BiConsumer<Reader, String> consumer) throws IOException {
        String name = file.getName();
        name = name.substring(0, name.indexOf('.'));
        Reader r = Files.newBufferedReader(file.toPath());
        consumer.accept(r, name);
    }

    public static void setupDefaultFiles(String dataPath, Path targetPath) {
        File targetDir = targetPath.toFile();
        if(!targetDir.exists())
            targetDir.mkdir();

        if (Files.isRegularFile(MOD_ROOT)) {
            try (FileSystem fileSystem = FileSystems.newFileSystem(MOD_ROOT)) {
                Path path = fileSystem.getPath(dataPath);
                if (Files.exists(path)) {
                    copyFiles(path, targetPath);
                }
            } catch (IOException e) {
                SuperOres.LOGGER.error("Could not load source {}!!", MOD_ROOT);
                e.printStackTrace();
            }
        } else if (Files.isDirectory(MOD_ROOT)) {
            copyFiles(Paths.get(MOD_ROOT.toString(), dataPath), targetPath);
        }
    }

    private static void copyFiles(Path source, Path targetPath) {
        try (Stream<Path> sourceStream = Files.walk(source)) {
            sourceStream.filter(f -> f.getFileName().toString().endsWith(JSON))
                    .forEach(path -> {
                        try {
                            Files.copy(path, Paths.get(targetPath.toString(), path.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            SuperOres.LOGGER.error("Could not copy file: {}, Target: {}", path, targetPath);
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            SuperOres.LOGGER.error("Could not stream source files: {}", source);
        }
    }
}
