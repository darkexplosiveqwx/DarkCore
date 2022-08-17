package net.darkexplosiveqwx.darkcore.DarkCore.block.entity;

import net.darkexplosiveqwx.darkcore.DarkCore.Main;
import net.darkexplosiveqwx.darkcore.DarkCore.block.ModBlocks;
import net.minecraft.world.level.block.entity.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Main.MOD_ID);

    public static final RegistryObject<BlockEntityType<GemInfusingStationBlockEntity>> GEM_INFUSING_STATION = BLOCK_ENTITIES.register("gem_infusing_station",
            () -> BlockEntityType.Builder.of(GemInfusingStationBlockEntity::new, ModBlocks.GEM_INFUSING_STATION.get()).build(null));


    public static void  register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

}
