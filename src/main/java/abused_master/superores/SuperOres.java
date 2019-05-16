package abused_master.superores;

import abused_master.superores.registry.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.io.File;

public class SuperOres implements ModInitializer {

    public static final String MODID = "superores";
    public static ItemGroup modItemGroup = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(Items.DIAMOND_PICKAXE));
    public static File configFile = new File(FabricLoader.getInstance().getConfigDirectory().getPath() + "/superores.json");

    @Override
    public void onInitialize() {
        ModBlocks.register();
        //ModBlocks.registerWorldGen();
    }
}
