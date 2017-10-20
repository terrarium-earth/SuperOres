package abused_master.superores.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class ModdedRegistry {

    private String oreDictName;

    public ModdedRegistry(String oreDict) {
        this.oreDictName = oreDict;
    }

    public String getOreDict() {
        return this.oreDictName;
    }

    public boolean doesOreExist() {
       return OreDictionary.doesOreNameExist(oreDictName);
    }

    public ItemStack getOreFromDict() {
        if(doesOreExist()) {
            return getOreDictItem(oreDictName);
        }
        return ItemStack.EMPTY;
    }

    public static ItemStack getOreDictItem(String name) {
        List<ItemStack> ores = OreDictionary.getOres(name);
        if(ores != null && ores.size() > 0) {
            return new ItemStack(ores.get(0).copy().getItem(), 1, ores.get(0).getMetadata());
        }
        return ItemStack.EMPTY;
    }
}
