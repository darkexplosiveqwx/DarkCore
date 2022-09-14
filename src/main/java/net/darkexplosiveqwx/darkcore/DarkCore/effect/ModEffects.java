package net.darkexplosiveqwx.darkcore.DarkCore.effect;

import net.darkexplosiveqwx.darkcore.DarkCore.DarkCore;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DarkCore.MOD_ID);


    public static final RegistryObject<MobEffect> AURA = MOB_EFFECTS.register("aura",
            () -> new AuraEffect(MobEffectCategory.BENEFICIAL, 4393481));

    public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register("freeze",
            () -> new FreezeEffect(MobEffectCategory.HARMFUL, 3124687));



    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
