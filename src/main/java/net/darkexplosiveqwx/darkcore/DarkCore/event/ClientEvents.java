package net.darkexplosiveqwx.darkcore.DarkCore.event;

import net.darkexplosiveqwx.darkcore.DarkCore.*;
import net.darkexplosiveqwx.darkcore.DarkCore.client.*;
import net.darkexplosiveqwx.darkcore.DarkCore.networking.*;
import net.darkexplosiveqwx.darkcore.DarkCore.networking.packet.*;
import net.darkexplosiveqwx.darkcore.DarkCore.util.*;
import net.minecraft.client.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(KeyBinding.DRINKING_KEY.consumeClick()){
                assert Minecraft.getInstance().player != null;
                ModMessages.sendToServer(new DrinkWaterC2SPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.DRINKING_KEY);
        }
        @SubscribeEvent
        public static void registerGUIOverlays(RegisterGuiOverlaysEvent event){
            event.registerAboveAll("thirst", ThirstHudOverlay.HUD_THIRST);
        }
    }

}
