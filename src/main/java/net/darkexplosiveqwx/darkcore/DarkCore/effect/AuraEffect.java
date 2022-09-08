package net.darkexplosiveqwx.darkcore.DarkCore.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AuraEffect extends MobEffect {

    protected AuraEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    /**
     * Returns the color of the potion liquid.
     */
    @Override
    public int getColor() {
        return 245;
    }

    @Override
    public @NotNull MobEffectCategory getCategory() {
        return MobEffectCategory.BENEFICIAL;
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity pLivingEntity, int pAmplifier) {

        EntityType.AREA_EFFECT_CLOUD.spawn((ServerLevel) pLivingEntity.level, ItemStack.EMPTY,
                pLivingEntity.createCommandSourceStack().getPlayer(), new BlockPos(pLivingEntity.position()),
                MobSpawnType.EVENT, false, true);
    }
}
