package abused_master.superores;

import abused_master.superores.client.ModClient;
import abused_master.superores.config.ClientConfig;
import abused_master.superores.config.CommonConfig;
import abused_master.superores.data.DataPackLoader;
import abused_master.superores.registry.ModBlocks;
import abused_master.superores.registry.ModWorldGen;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;

@Mod(SuperOres.MODID)
public class SuperOres {

    public static final String MODID = "superores";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public SuperOres() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::init);
        modBus.addListener(this::initClient);
        modBus.addListener(this::onPackFinder);
        ModBlocks.BLOCKS.register(modBus);
        ModBlocks.ITEMS.register(modBus);
        MinecraftForge.EVENT_BUS.addListener(ModWorldGen::onBiomeLoad);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG_SPEC, "superores/common.toml");
        loadConfig(CommonConfig.CONFIG_SPEC, "superores/common.toml");
        ModBlocks.init();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.CONFIG_SPEC, "superores/client.toml");
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> loadConfig(ClientConfig.CONFIG_SPEC, "superores/client.toml"));
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ModClient::init);
        if (FMLLoader.isProduction()) {
            CommonConfig.GENERATE_DEFAULTS.set(false);
            CommonConfig.GENERATE_DEFAULTS.save();

            ClientConfig.GENERATE_LANG.set(false);
            ClientConfig.GENERATE_LANG.save();
        }
    }

    private void init(FMLCommonSetupEvent event) {
        ModWorldGen.init();
    }

    private void initClient(FMLClientSetupEvent event) {
        //ModClient.initClient(event);
    }

    public void onPackFinder(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA)
            event.addRepositorySource(DataPackLoader.INSTANCE);
    }

    private static void loadConfig(ForgeConfigSpec config, String location) {
        Path path = FMLPaths.CONFIGDIR.get().resolve(location);
        CommentedFileConfig data = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        data.load();
        config.setConfig(data);
    }
}
