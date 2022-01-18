package abused_master.superores.block;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SuperOreBlock extends Block {

    private final OreEntry oreEntry;
    private final boolean isDeepslate;

    public SuperOreBlock(OreEntry oreEntry, boolean isDeepslate) {
        super(Properties.of(Material.STONE).strength(oreEntry.getConfig().oreProperties().strength() + (isDeepslate ? 2f : 0), 4).requiresCorrectToolForDrops());
        this.oreEntry = oreEntry;
        this.isDeepslate = isDeepslate;
    }

    public SuperOreBlock(OreEntry oreEntry) {
        this(oreEntry, false);
    }

    @NotNull
    @Override
    public List<ItemStack> getDrops(@NotNull BlockState state, @NotNull LootContext.Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);
        if (drops.isEmpty()) {
            int amount = oreEntry.getConfig().oreDrop().dropChance().sample(RANDOM);
            drops.add(new ItemStack(oreEntry.getConfig().oreDrop().item(), amount));
        }

        return drops;
    }

    public OreEntry getOreEntry() {
        return oreEntry;
    }

    public boolean isDeepslate() {
        return isDeepslate;
    }
}
