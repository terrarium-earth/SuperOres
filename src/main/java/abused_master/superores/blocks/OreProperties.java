package abused_master.superores.blocks;

public class OreProperties {

    private String name;
    private float hardness;
    private int miningLevel, dropAmount;
    private String droppedBlock;
    private OreGenProperties oreGenProperties;

    public OreProperties(String name, float hardness, int miningLevel, int dropAmount, String droppedBlock, OreGenProperties oreGenProperties) {
        this.name = name;
        this.hardness = hardness;
        this.miningLevel = miningLevel;
        this.dropAmount = dropAmount;
        this.droppedBlock = droppedBlock;
        this.oreGenProperties = oreGenProperties;
    }

    public String getName() {
        return name;
    }

    public float getHardness() {
        return hardness;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public int getDropAmount() {
        return dropAmount;
    }

    public String getDroppedBlock() {
        return droppedBlock;
    }

    public OreGenProperties getOreGenProperties() {
        return oreGenProperties;
    }
}
