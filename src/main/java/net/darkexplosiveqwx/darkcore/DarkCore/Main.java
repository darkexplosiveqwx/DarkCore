package net.darkexplosiveqwx.darkcore.DarkCore;

import com.mojang.logging.LogUtils;
import net.darkexplosiveqwx.darkcore.DarkCore.block.ModBlocks;
import net.darkexplosiveqwx.darkcore.DarkCore.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "darkcore";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event){

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public  static class  ClientModEvents{
        @SubscribeEvent
        public static void  onClientSetup(FMLClientSetupEvent event){
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUEBERRY_CROP.get(), RenderType.cutout());
        }
    }

}
