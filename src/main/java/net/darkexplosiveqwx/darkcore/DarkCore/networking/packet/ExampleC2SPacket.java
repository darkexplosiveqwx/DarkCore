package net.darkexplosiveqwx.darkcore.DarkCore.networking.packet;

import net.minecraft.network.*;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.*;
import net.minecraftforge.network.*;

import java.util.function.Supplier;

public class ExampleC2SPacket {
    public ExampleC2SPacket(){

    }

    public ExampleC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(()->{
            //SERVER SIDE NOW
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            EntityType.COW.spawn(level, null, null, player.blockPosition(), MobSpawnType.TRIGGERED,true, false);
        });
        return true;
    }
}
