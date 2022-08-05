package net.darkexplosiveqwx.darkcore.DarkCore.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DiceItem extends Item {
    public DiceItem(Properties pProperties) {
        super(pProperties);
    }



    @Override
    public InteractionResultHolder<ItemStack> use( Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide() && pUsedHand == InteractionHand.MAIN_HAND){
            outputRandomNumber(pPlayer);
            pPlayer.getCooldowns().addCooldown(this, 20);

        }


        return super.use(pLevel, pPlayer, pUsedHand);
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            components.add(Component.translatable("text.darkcore.diceiteminfo").withStyle(ChatFormatting.AQUA));
        }else {
            components.add(Component.translatable("text.darkcore.pressshift").withStyle(ChatFormatting.YELLOW));
        }


        super.appendHoverText(stack, level, components, flag);
    }

    private void outputRandomNumber(Player player){
        player.sendSystemMessage(Component.literal("["+ player.getName().toString() + "]" +"Your Number is " + getRandomNumber()));
    }

    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(7);

    }
}
