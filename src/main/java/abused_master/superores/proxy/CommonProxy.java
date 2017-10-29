package abused_master.superores.proxy;

import abused_master.superores.registry.ModBlocks;
import abused_master.superores.registry.SuperOresGeneration;
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

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
        GameRegistry.registerWorldGenerator(new SuperOresGeneration(), 10);
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(ModBlocks.CoalOre);
        event.getRegistry().register(ModBlocks.IronOre);
        event.getRegistry().register(ModBlocks.RedstoneOre);
        event.getRegistry().register(ModBlocks.LapisOre);
        event.getRegistry().register(ModBlocks.GoldOre);
        event.getRegistry().register(ModBlocks.DiamondOre);
        event.getRegistry().register(ModBlocks.EmeraldOre);
        event.getRegistry().register(ModBlocks.QuartzOre);

        /**
         * Modded Ores
         */
        event.getRegistry().register(ModBlocks.CopperOre);
        event.getRegistry().register(ModBlocks.AluminumOre);
        event.getRegistry().register(ModBlocks.LeadOre);
        event.getRegistry().register(ModBlocks.NickelOre);
        event.getRegistry().register(ModBlocks.OsmiumOre);
        event.getRegistry().register(ModBlocks.SilverOre);
        event.getRegistry().register(ModBlocks.UraniumOre);
        event.getRegistry().register(ModBlocks.PlatinumOre);
        event.getRegistry().register(ModBlocks.TinOre);
        event.getRegistry().register(ModBlocks.ArditeOre);
        event.getRegistry().register(ModBlocks.CobaltOre);
        event.getRegistry().register(ModBlocks.IridiumOre);
        event.getRegistry().register(ModBlocks.YelloriteOre);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.CoalOre).setRegistryName(ModBlocks.CoalOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.IronOre).setRegistryName(ModBlocks.IronOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.RedstoneOre).setRegistryName(ModBlocks.RedstoneOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.LapisOre).setRegistryName(ModBlocks.LapisOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.GoldOre).setRegistryName(ModBlocks.GoldOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.DiamondOre).setRegistryName(ModBlocks.DiamondOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.EmeraldOre).setRegistryName(ModBlocks.EmeraldOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.QuartzOre).setRegistryName(ModBlocks.QuartzOre.getRegistryName()));

        /**
         * Modded Ores
         */
        event.getRegistry().register(new ItemBlock(ModBlocks.CopperOre).setRegistryName(ModBlocks.CopperOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.AluminumOre).setRegistryName(ModBlocks.AluminumOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.LeadOre).setRegistryName(ModBlocks.LeadOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.NickelOre).setRegistryName(ModBlocks.NickelOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.OsmiumOre).setRegistryName(ModBlocks.OsmiumOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.SilverOre).setRegistryName(ModBlocks.SilverOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.UraniumOre).setRegistryName(ModBlocks.UraniumOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.PlatinumOre).setRegistryName(ModBlocks.PlatinumOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.TinOre).setRegistryName(ModBlocks.TinOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.ArditeOre).setRegistryName(ModBlocks.ArditeOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.CobaltOre).setRegistryName(ModBlocks.CobaltOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.IridiumOre).setRegistryName(ModBlocks.IridiumOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.YelloriteOre).setRegistryName(ModBlocks.YelloriteOre.getRegistryName()));
    }
}
