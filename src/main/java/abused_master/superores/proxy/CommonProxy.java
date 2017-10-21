package abused_master.superores.proxy;

import abused_master.superores.blocks.ModdedResources;
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
        GameRegistry.registerWorldGenerator(new SuperOresGeneration(), 0);
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

        /**
         * Modded Ores
         */

        if(ModdedResources.Copper.doesOreExist()) {
            event.getRegistry().register(ModBlocks.CopperOre);
        }

        if(ModdedResources.Aluminum.doesOreExist()) {
            event.getRegistry().register(ModBlocks.AluminumOre);
        }

        if(ModdedResources.Lead.doesOreExist()) {
            event.getRegistry().register(ModBlocks.LeadOre);
        }

        if(ModdedResources.Nickel.doesOreExist()) {
            event.getRegistry().register(ModBlocks.NickelOre);
        }

        if(ModdedResources.Osmium.doesOreExist()) {
            event.getRegistry().register(ModBlocks.OsmiumOre);
        }

        if(ModdedResources.Silver.doesOreExist()) {
            event.getRegistry().register(ModBlocks.SilverOre);
        }

        if(ModdedResources.Uranium.doesOreExist()) {
            event.getRegistry().register(ModBlocks.UraniumOre);
        }

        if(ModdedResources.Platinum.doesOreExist()) {
            event.getRegistry().register(ModBlocks.PlatinumOre);
        }

        if(ModdedResources.Tin.doesOreExist()) {
            event.getRegistry().register(ModBlocks.TinOre);
        }
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

        /**
         * Modded Ores
         */

        if(ModdedResources.Copper.doesOreExist()) {
            event.getRegistry().register(new ItemBlock(ModBlocks.CopperOre).setRegistryName(ModBlocks.CopperOre.getRegistryName()));
        }

        if(ModdedResources.Aluminum.doesOreExist()) {
            event.getRegistry().register(new ItemBlock(ModBlocks.AluminumOre).setRegistryName(ModBlocks.AluminumOre.getRegistryName()));
        }

        if(ModdedResources.Lead.doesOreExist()) {
            event.getRegistry().register(new ItemBlock(ModBlocks.LeadOre).setRegistryName(ModBlocks.LeadOre.getRegistryName()));
        }

        if(ModdedResources.Nickel.doesOreExist()) {
            event.getRegistry().register(new ItemBlock(ModBlocks.NickelOre).setRegistryName(ModBlocks.NickelOre.getRegistryName()));
        }

        if(ModdedResources.Osmium.doesOreExist()) {
            event.getRegistry().register(new ItemBlock(ModBlocks.OsmiumOre).setRegistryName(ModBlocks.OsmiumOre.getRegistryName()));
        }

        if(ModdedResources.Silver.doesOreExist()) {
            event.getRegistry().register(new ItemBlock(ModBlocks.SilverOre).setRegistryName(ModBlocks.SilverOre.getRegistryName()));
        }

        if(ModdedResources.Uranium.doesOreExist()) {
            event.getRegistry().register(new ItemBlock(ModBlocks.UraniumOre).setRegistryName(ModBlocks.UraniumOre.getRegistryName()));
        }

        if(ModdedResources.Platinum.doesOreExist()) {
            event.getRegistry().register(new ItemBlock(ModBlocks.PlatinumOre).setRegistryName(ModBlocks.PlatinumOre.getRegistryName()));
        }

        if(ModdedResources.Tin.doesOreExist()) {
            event.getRegistry().register(new ItemBlock(ModBlocks.TinOre).setRegistryName(ModBlocks.TinOre.getRegistryName()));
        }
    }
}
