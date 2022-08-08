package net.darkexplosiveqwx.darkcore.DarkCore;

import com.mojang.logging.*;
import net.darkexplosiveqwx.darkcore.DarkCore.block.*;
import net.darkexplosiveqwx.darkcore.DarkCore.item.*;
import net.darkexplosiveqwx.darkcore.DarkCore.painting.*;
import net.darkexplosiveqwx.darkcore.DarkCore.villager.*;
import net.darkexplosiveqwx.darkcore.DarkCore.world.feature.*;
import net.minecraftforge.common.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.*;
import org.slf4j.*;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "darkcore";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModPaintings.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public  static class  ClientModEvents{
        @SubscribeEvent
        public static void  onClientSetup(FMLClientSetupEvent event){
        }
    }

}
