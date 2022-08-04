package net.darkexplosiveqwx.darkcore.DarkCore.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class JumpyBlock extends Block {
    public JumpyBlock(Properties properties) {
        super(properties);
    }


    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult blockHitResult) {
        if (!level.isClientSide() && hand.equals(InteractionHand.MAIN_HAND) && player.getMainHandItem().equals(ItemStack.EMPTY)) {
            player.removeAllEffects();
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1200));
            player.sendSystemMessage(Component.literal("Buffed " + player.getName()));
        }

        return super.use(state, level, pos, player, hand, blockHitResult);
    }

    @Override
    public void stepOn(@NotNull Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP,200));
        }



        super.stepOn(level, pos, state, entity);
    }


}
