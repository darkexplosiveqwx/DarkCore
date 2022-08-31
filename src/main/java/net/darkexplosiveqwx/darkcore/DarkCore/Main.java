package net.darkexplosiveqwx.darkcore.DarkCore;

import com.mojang.logging.*;
import net.darkexplosiveqwx.darkcore.DarkCore.block.*;
import net.darkexplosiveqwx.darkcore.DarkCore.block.entity.ModBlockEntities;
import net.darkexplosiveqwx.darkcore.DarkCore.fluid.*;
import net.darkexplosiveqwx.darkcore.DarkCore.item.*;
import net.darkexplosiveqwx.darkcore.DarkCore.networking.*;
import net.darkexplosiveqwx.darkcore.DarkCore.painting.*;
import net.darkexplosiveqwx.darkcore.DarkCore.recipe.ModRecipes;
import net.darkexplosiveqwx.darkcore.DarkCore.screen.DarkCraftingTableScreen;
import net.darkexplosiveqwx.darkcore.DarkCore.screen.GemInfusingStationScreen;
import net.darkexplosiveqwx.darkcore.DarkCore.screen.ModMenuTypes;
import net.darkexplosiveqwx.darkcore.DarkCore.villager.*;
import net.darkexplosiveqwx.darkcore.DarkCore.world.feature.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.*;
import net.minecraftforge.common.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.*;
import org.jetbrains.annotations.*;
import org.slf4j.*;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "darkcore";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Main() {
        LOGGER.debug("Mod DarkCore started!");

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModPaintings.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModFluidsTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        LOGGER.debug("registered all classes!");

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.debug("Successful!");
    }

    private void commonSetup(final @NotNull FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
            ModMessages.register();
        });

        ModMessages.register();
        LOGGER.debug("Successful commonSetup!");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public  static class  ClientModEvents{
        @SubscribeEvent
        public static void  onClientSetup(FMLClientSetupEvent event){
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SOAP_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SOAP_WATER.get(), RenderType.translucent());

            MenuScreens.register(ModMenuTypes.GEM_INFUSING_STATION_MENU.get(), GemInfusingStationScreen::new);
            MenuScreens.register(ModMenuTypes.DARK_CRAFTING_TABLE_MENU.get(), DarkCraftingTableScreen::new);
            LOGGER.debug("Successful onClientSetup!");
        }
    }

}
