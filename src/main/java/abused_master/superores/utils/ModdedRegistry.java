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
        if(OreDictionary.doesOreNameExist(oreDictName)) {
            return true;
        }
        return false;
    }

    public ItemStack getOreFromDict() {
        if(doesOreExist()) {
            return getOreDict(oreDictName).copy();
        }
        return ItemStack.EMPTY;
    }

    public static ItemStack getOreDict(String oreIdName) {
        List<ItemStack> ores = OreDictionary.getOres(oreIdName);
        if (ores != null && ores.size() > 0)
            return ores.get(0).copy();
        return ItemStack.EMPTY;
    }
}
