package abused_master.superores.data;

import abused_master.superores.SuperOres;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Taken from Resourceful Bees, Thx Gravy <3
 */
public abstract class GenericMemoryPack implements PackResources {

    private final HashMap<ResourceLocation, Supplier<? extends InputStream>> data = new HashMap<>();

    private final JsonObject metaData;
    private final PackType allowedType;
    private final String id;

    protected GenericMemoryPack(PackType type, String id, String meta) {
        this.metaData = SuperOres.GSON.fromJson(meta, JsonObject.class);
        this.allowedType = type;
        this.id = id;
    }

    private boolean isTypeAllowed(PackType type) {
        return allowedType.equals(type);
    }

    public void putData(PackType type, ResourceLocation location, Supplier<? extends InputStream> supplier) {
        if (!isTypeAllowed(type)) return;
        data.put(location, supplier);
    }

    public void putJson(PackType type, ResourceLocation location, JsonElement json) {
        putData(type, location, () -> new ByteArrayInputStream(SuperOres.GSON.toJson(json).getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public @NotNull InputStream getRootResource(@NotNull String file) throws IOException {
        if (file.contains("/") || file.contains("\\")) {
            throw new IllegalArgumentException("Root resources can only be filenames, not paths (no / allowed!)");
        }
        throw new FileNotFoundException(file);
    }

    @Override
    public @NotNull InputStream getResource(@NotNull PackType type, @NotNull ResourceLocation location) throws IOException {
        if (this.hasResource(type, location)) return data.get(location).get();
        throw new FileNotFoundException(location.toString());
    }

    @Override
    public @NotNull
    Collection<ResourceLocation> getResources(@NotNull PackType type, @NotNull String namespace, @NotNull String path, int maxFolderWalk, @NotNull Predicate<String> predicate) {
        if (!isTypeAllowed(type)) return Collections.emptyList();
        return data.keySet().stream()
                .filter(location -> location.getNamespace().equals(namespace))
                .filter(location -> location.getPath().split("/").length < maxFolderWalk)
                .filter(location -> location.getPath().startsWith(path))
                .filter(location -> predicate.test(location.getPath().substring(Math.max(location.getPath().lastIndexOf('/'), 0)))
                ).collect(Collectors.toList());
    }

    @Override
    public boolean hasResource(@NotNull PackType type, @NotNull ResourceLocation location) {
        return isTypeAllowed(type) && data.containsKey(location);
    }

    @Override
    public @NotNull
    Set<String> getNamespaces(@NotNull PackType type) {
        if (!isTypeAllowed(type)) return Collections.emptySet();
        return data.keySet().stream().map(ResourceLocation::getNamespace).collect(Collectors.toSet());
    }

    @Nullable
    @Override
    public <T> T getMetadataSection(@NotNull MetadataSectionSerializer<T> serializer) {
        if (!serializer.getMetadataSectionName().equals("pack")) return null;
        return serializer.fromJson(metaData);
    }

    @Override
    public @NotNull String getName() {
        return id;
    }

    @Override
    public boolean isHidden() {
        return true;
    }

    @Override
    public void close() {
        //Does nothing
    }
}