package abused_master.superores;

import abused_master.superores.proxy.CommonProxy;
import abused_master.superores.registry.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SuperOres.MODID, name = SuperOres.MODNAME, version = SuperOres.VERSION,
acceptedMinecraftVersions = SuperOres.ACCEPTED_VERSIONS)
public class SuperOres {

    public static final String MODID = "superores";
    public static final String MODNAME = "Super Ores";
    public static final String VERSION = "1.8.1_1.12";
    public static final String ACCEPTED_VERSIONS = "[1.12,1.12.2]";

    @SidedProxy(clientSide = "abused_master.superores.proxy.ClientProxy", serverSide = "abused_master.superores.proxy.CommonProxy")
    static CommonProxy proxy;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);
        Config.init(e);
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
            return new ItemStack(ModBlocks.DiamondOre);
        }
    };
}
