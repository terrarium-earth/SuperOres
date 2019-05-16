package abused_master.superores.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.FabricItemTags;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.loot.context.LootContext;

import java.util.Collections;
import java.util.List;

public class BlockOreBase extends Block {

    public OreProperties properties;

    public BlockOreBase(OreProperties properties) {
        super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricItemTags.PICKAXES, properties.getMiningLevel()).hardness(properties.getHardness()).build());
        this.properties = properties;
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        int dropAmount = builder.getWorld().random.nextInt(properties.getDropAmount());
        ItemStack droppedStack = ItemStack.EMPTY;
        if(Registry.ITEM.get(new Identifier(properties.getDroppedBlock())) != null) {
            droppedStack = new ItemStack(Registry.BLOCK.get(new Identifier(properties.getDroppedBlock())), dropAmount > 2 ? dropAmount : 2 + dropAmount);
        }else if(Registry.BLOCK.get(new Identifier(properties.getDroppedBlock())) != null) {
            droppedStack = new ItemStack(Registry.BLOCK.get(new Identifier(properties.getDroppedBlock())), dropAmount > 2 ? dropAmount : 2 + dropAmount);
        }else if(TagRegistry.item(new Identifier(properties.getDroppedBlock())) != null && !TagRegistry.item(new Identifier(properties.getDroppedBlock())).values().isEmpty()) {
            droppedStack = new ItemStack((Item) TagRegistry.item(new Identifier(properties.getDroppedBlock())).values().toArray()[0], dropAmount > 2 ? dropAmount : 2 + dropAmount);
        } else if (TagRegistry.block(new Identifier(properties.getDroppedBlock())) != null && !TagRegistry.block(new Identifier(properties.getDroppedBlock())).values().isEmpty()) {
            droppedStack = new ItemStack((Block) TagRegistry.block(new Identifier(properties.getDroppedBlock())).values().toArray()[0], dropAmount > 2 ? dropAmount : 2 + dropAmount);
        }

        return Collections.singletonList(droppedStack);
    }
}
