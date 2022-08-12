package net.darkexplosiveqwx.darkcore.DarkCore.networking;

import net.darkexplosiveqwx.darkcore.DarkCore.*;
import net.darkexplosiveqwx.darkcore.DarkCore.networking.packet.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraftforge.network.*;
import net.minecraftforge.network.simple.*;

public class ModMessages {
    private static SimpleChannel INSTANCE;


    private static int packedId = 0;
    private static int id(){
        return packedId++;
    }

    public static void register(){
    SimpleChannel net = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(Main.MOD_ID,"messages"))
            .networkProtocolVersion(()->"1.0")
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();

    INSTANCE = net;

    net.messageBuilder(ExampleC2SPacket.class,id(),NetworkDirection.PLAY_TO_SERVER)
            .decoder(ExampleC2SPacket::new)
            .encoder(ExampleC2SPacket::toBytes)
            .consumerMainThread(ExampleC2SPacket::handle)
            .add();
    net.messageBuilder(DrinkWaterC2SPacket.class,id(),NetworkDirection.PLAY_TO_SERVER)
            .decoder(DrinkWaterC2SPacket::new)
            .encoder(DrinkWaterC2SPacket::toBytes)
            .consumerMainThread(DrinkWaterC2SPacket::handle)
            .add();

        net.messageBuilder(ThirstDataSyncS2CPacket.class,id(),NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ThirstDataSyncS2CPacket::new)
                .encoder(ThirstDataSyncS2CPacket::toBytes)
                .consumerMainThread(ThirstDataSyncS2CPacket::handle)
                .add();

    }

    public static <MSG> void sendToServer(MSG message){
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(()-> player), message);
    }

}