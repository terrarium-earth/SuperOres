package abused_master.superores;

import abused_master.superores.proxy.CommonProxy;
import abused_master.superores.registry.ModResources;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Info.MODID, name = Info.MODNAME, version = Info.VERSION, acceptedMinecraftVersions = Info.ACCEPTED_VERSIONS, dependencies = "required-after:forge@[14.23.1.2577,);after:mekanism;after:*;after:tconstruct;after:bigreactors;after:appliedenergistics2")
public class SuperOres {
	
    @SidedProxy(clientSide = "abused_master.superores.proxy.ClientProxy", serverSide = "abused_master.superores.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        this.proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        this.proxy.postInit(e);
    }

    public static CreativeTabs SuperOresTab = new CreativeTabs("superores") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModResources.ORES.get(0));
        }
    };

    @SubscribeEvent
 	public void onNameFormat(PlayerEvent.NameFormat event) {
        if (event.getUsername().compareTo("abused_master") == 0) {
            event.setDisplayname(TextFormatting.LIGHT_PURPLE + event.getUsername());
        }
    }
}
