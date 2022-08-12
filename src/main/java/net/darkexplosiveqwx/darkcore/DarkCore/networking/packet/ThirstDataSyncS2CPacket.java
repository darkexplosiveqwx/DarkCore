 package net.darkexplosiveqwx.darkcore.DarkCore.networking.packet;

 import net.darkexplosiveqwx.darkcore.DarkCore.client.*;
 import net.minecraft.network.*;
 import net.minecraftforge.network.*;

 import java.util.function.Supplier;

 public class ThirstDataSyncS2CPacket {
     private final int thirst;
     public ThirstDataSyncS2CPacket(int thirst){

         this.thirst = thirst;
     }

     public ThirstDataSyncS2CPacket(FriendlyByteBuf buf){

         this.thirst = buf.readInt();
     }

     public void toBytes(FriendlyByteBuf buf){
         buf.writeInt(thirst);
     }

     public boolean handle(Supplier<NetworkEvent.Context> supplier){
         NetworkEvent.Context context = supplier.get();
         context.enqueueWork(()->{
             //CLIENT SIDE NOW
             ClientThirstData.setPlayerThirst(thirst);
         });
         return true;
     }

 }
