package net.darkexplosiveqwx.darkcore.DarkCore.enchantment;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import org.jetbrains.annotations.NotNull;


public class WitherEnchantment extends Enchantment {
    public WitherEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    /**
     * ItemStack aware version of {@link Enchantment#getDamageBonus(int, MobType)}
     *
     * @param level         the level of the enchantment
     * @param mobType       the mob type being attacked
     * @param enchantedItem the item used for the attack
     * @return the damage bonus
     */
    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        if (level == 1){
            return 0f;
        }else if (level == 2){
            return 1f;
        }else if (level == 3){
            return 1.5f;
        }else if (level == 4){
            return 2f;
        }else {
            return (float) level;
        }
    }

    /**
     * Checks if the enchantment can be sold by villagers in their trades.
     */
    @Override
    public boolean isTradeable() {
        return false;
    }

    /**
     * Checks if the enchantment is considered a curse. These enchantments are treated as debuffs and can not be removed
     * from items under normal circumstances.
     *
     * @return Whether or not the enchantment is a curse.
     */
    @Override
    public boolean isCurse() {
        return false;
    }

    /**
     * Checks if the enchantment can be applied to loot table drops.
     */
    @Override
    public boolean isDiscoverable() {
        return true;
    }

    /**
     * Whenever an entity that has this enchantment on one of its associated items is damaged this method will be called.
     *
     * @param pTarget
     * @param pAttacker The entity that attacked the target.
     * @param pLevel    The level of the enchantment.
     */
    @Override
    public void doPostHurt(@NotNull LivingEntity pTarget, @NotNull Entity pAttacker, int pLevel) {
        LivingEntity livingPTarget = (LivingEntity) pAttacker;


        if (pLevel == 1){
            livingPTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 1));
        }else if (pLevel == 2){
            livingPTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1));
        }else if (pLevel == 3){
            livingPTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 90, 2));
        }else if (pLevel == 4){
            livingPTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 120, 3));
        }
        if(livingPTarget.canAttack(livingPTarget)){
            livingPTarget.animateHurt();
            livingPTarget.hurt(DamageSource.MAGIC,2f);
        }
    }


    /**
     * Called whenever a mob is damaged with an item that has this enchantment on it.
     *
     * @param pAttacker
     * @param pTarget   The entity being attacked.
     * @param pLevel    The level of the enchantment.
     */
    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        LivingEntity livingPTarget = (LivingEntity) pTarget;

        if (pLevel == 1){
            livingPTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 1));
        }else if (pLevel == 2){
            livingPTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1));
        }else if (pLevel == 3){
            livingPTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 90, 2));
        }else if (pLevel == 4){
            livingPTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 120, 3));
        }
        if(livingPTarget.canAttack(livingPTarget)){
            livingPTarget.animateHurt();
            livingPTarget.hurt(DamageSource.MAGIC,2f);
        }
        pAttacker.removeEffect(MobEffects.WITHER);
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }

    /**
     * Determines what creative tabs this enchantment's variant of an enchanted book or similar item should appear in.
     *
     * @param book The item being added to the creative tab
     * @param tab  The creative tab that items are being added to
     * @return whether the given Item's variant for this enchantment should appear in the respective creative tab
     */
    @Override
    public boolean allowedInCreativeTab(Item book, CreativeModeTab tab) {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
