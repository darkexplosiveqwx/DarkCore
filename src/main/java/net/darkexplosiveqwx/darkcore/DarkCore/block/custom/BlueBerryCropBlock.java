package net.darkexplosiveqwx.darkcore.DarkCore.block.custom;

import net.darkexplosiveqwx.darkcore.DarkCore.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;

public class BlueBerryCropBlock extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);

    public BlueBerryCropBlock(Properties properties) {
        super(properties);
    }


    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.BLUEBERRY_SEEDS.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 6;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
