package net.darkexplosiveqwx.darkcore.DarkCore;

import com.mojang.logging.LogUtils;
import net.darkexplosiveqwx.darkcore.DarkCore.block.ModBlocks;
import net.darkexplosiveqwx.darkcore.DarkCore.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "darkcore";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
