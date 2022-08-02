package net.darkexplosiveqwx.darkcore.DarkCore.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class ZirconLampBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.create("lit");


    public ZirconLampBlock(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND && player.getMainHandItem() == ItemStack.EMPTY) {
           level.setBlock(blockPos, state.cycle(LIT),3);
        }

        return super.use(state, level, blockPos, player, hand, result);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

}
