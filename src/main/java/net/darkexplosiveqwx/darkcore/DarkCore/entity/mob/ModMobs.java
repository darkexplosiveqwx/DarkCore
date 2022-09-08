package net.darkexplosiveqwx.darkcore.DarkCore.entity.mob;

import net.darkexplosiveqwx.darkcore.DarkCore.MainForge;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;
/**
 * @author darkexplosivqwx
 */
public class ModMobs {
    public static final DeferredRegister<EntityType<?>> MOBS = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MainForge.MOD_ID);



    public static void register(IEventBus eventBus){
        MOBS.register(eventBus);
    }


}
