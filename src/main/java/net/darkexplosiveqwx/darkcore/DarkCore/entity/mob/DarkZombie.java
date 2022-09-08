package net.darkexplosiveqwx.darkcore.DarkCore.entity.mob;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DarkZombie  extends Zombie {
    public DarkZombie(EntityType<? extends DarkZombie> p_32889_, Level p_32890_) {
        super(p_32889_, p_32890_);
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.HUSK_AMBIENT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource p_32903_) {
        return SoundEvents.HUSK_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.HUSK_DEATH;
    }
    @Override
    protected @NotNull SoundEvent getStepSound() {
        return SoundEvents.HUSK_STEP;
    }

    @Override
    public boolean canBreakDoors() {
        return true;
    }

    @Override
    public boolean canFreeze() {
        return false;
    }
}
