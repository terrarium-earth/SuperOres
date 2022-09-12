package abused_master.superores.block;

import abused_master.superores.api.ore.OreConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class OreEntry {

    private final OreConfig oreConfig;
    private Supplier<SuperOreBlock> oreBlock;
    private Supplier<SuperOreBlock> deepslateOreBlock;

    public OreEntry(OreConfig oreConfig) {
        this.oreConfig = oreConfig;
    }

    public void setOreBlock(Supplier<SuperOreBlock> oreBlock) {
        this.oreBlock = oreBlock;
    }

    public void setDeepslateOreBlock(Supplier<SuperOreBlock> deepslateOreBlock) {
        this.deepslateOreBlock = deepslateOreBlock;
    }

    public OreConfig getConfig() {
        return oreConfig;
    }

    @NotNull
    public SuperOreBlock getOreBlock() {
        return oreBlock.get();
    }

    @Nullable
    public SuperOreBlock getDeepslateOreBlock() {
        return deepslateOreBlock == null ? null : deepslateOreBlock.get();
    }
}
