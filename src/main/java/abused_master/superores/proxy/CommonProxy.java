package abused_master.superores.proxy;

import abused_master.superores.blocks.BlockOreBase;
import abused_master.superores.registry.ModResources;
import abused_master.superores.registry.WorldGeneration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModResources.register();
    }

    public void init(FMLInitializationEvent e) {
        WorldGeneration worldGen = new WorldGeneration();
        ModResources.addWorldGen(worldGen);
        GameRegistry.registerWorldGenerator(worldGen, 0);
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for (BlockOreBase ore : ModResources.ORES) {
            if(OreDictionary.doesOreNameExist(ore.getOreDictName())) {
                event.getRegistry().register(ore);
            }else {
                System.out.println("Ore not found!!! " + ore.getOreDictName());
            }
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (BlockOreBase ore : ModResources.ORES) {
            if(OreDictionary.doesOreNameExist(ore.getOreDictName())) {
                event.getRegistry().register(new ItemBlock(ore).setRegistryName(ore.getRegistryName()));
            }
        }
    }
}
