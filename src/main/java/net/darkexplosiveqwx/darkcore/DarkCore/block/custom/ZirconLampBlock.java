package net.darkexplosiveqwx.darkcore.DarkCore.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ZirconLampBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.create("lit");


    public ZirconLampBlock(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND && player.getMainHandItem() == ItemStack.EMPTY) {
           level.setBlock(blockPos, state.cycle(LIT),3);
        }

        return super.use(state, level, blockPos, player, hand, result);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> bulider) {
        bulider.add(LIT);
    }

}
