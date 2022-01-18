package abused_master.superores.block;

import abused_master.superores.api.ore.OreConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OreEntry {

    private final OreConfig oreConfig;
    private SuperOreBlock oreBlock;
    private SuperOreBlock deepslateOreBlock;

    public OreEntry(OreConfig oreConfig) {
        this.oreConfig = oreConfig;
    }

    public void setOreBlock(SuperOreBlock oreBlock) {
        this.oreBlock = oreBlock;
    }

    public void setDeepslateOreBlock(SuperOreBlock deepslateOreBlock) {
        this.deepslateOreBlock = deepslateOreBlock;
    }

    public OreConfig getConfig() {
        return oreConfig;
    }

    @NotNull
    public SuperOreBlock getOreBlock() {
        return oreBlock;
    }

    @Nullable
    public SuperOreBlock getDeepslateOreBlock() {
        return deepslateOreBlock;
    }
}
