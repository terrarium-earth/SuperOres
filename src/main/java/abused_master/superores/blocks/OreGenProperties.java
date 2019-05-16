package abused_master.superores.blocks;

public class OreGenProperties {

    private int size, count, maxHeight;
    private boolean enabled;

    public OreGenProperties(int size, int count, int maxHeight, boolean enabled) {
        this.size = size;
        this.count = count;
        this.maxHeight = maxHeight;
        this.enabled = enabled;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
