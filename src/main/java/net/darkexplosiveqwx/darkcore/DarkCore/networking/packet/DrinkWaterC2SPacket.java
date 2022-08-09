 package net.darkexplosiveqwx.darkcore.DarkCore.networking.packet;

import net.minecraft.*;
import net.minecraft.network.*;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.*;

import java.util.function.*;

public class DrinkWaterC2SPacket {
    private static final String MESSAGE_DRINK_WATER = "message.darkcore.drink_water";
    private static final String MESSAGE_NO_WATER = "message.darkcore.no_water";

    public DrinkWaterC2SPacket(){

    }

    public DrinkWaterC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(()->{
            //SERVER SIDE NOW
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            if(hasWaterAroundThem(player, level, 2)) {
                // Notify the player that water has been drunk
                player.sendSystemMessage(Component.translatable(MESSAGE_DRINK_WATER).withStyle(ChatFormatting.DARK_AQUA));
                // play the drinking sound
                level.playSound(null, player.getOnPos(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS,
                        0.5F, level.random.nextFloat() * 0.1F + 0.9F);

                // increase the water level / thirst level of player

                // Output the current thirst level

            } else {
                // Notify the player that there is no water around!
                player.sendSystemMessage(Component.translatable(MESSAGE_NO_WATER).withStyle(ChatFormatting.RED));
                // Output the current thirst level
            }


        });
        return true;
    }

    private boolean hasWaterAroundThem(ServerPlayer player, ServerLevel level, int size) {
        return level.getBlockStates(player.getBoundingBox().inflate(size)).filter(state -> state.is(Blocks.WATER)).toArray().length > 0;
    }
}
