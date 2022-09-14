package net.darkexplosiveqwx.darkcore.DarkCore.fluid;


import com.mojang.math.Vector3f;
import net.darkexplosiveqwx.darkcore.DarkCore.DarkCore;
import net.minecraft.resources.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.*;

public class ModFluidsTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation SOAP_OVERLAY_RL = new ResourceLocation(DarkCore.MOD_ID, "misc/in_soap_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DarkCore.MOD_ID);


    public static RegistryObject<FluidType> SOAP_WATER_FLUID_TYPE = register("soap_water_fluid", SOAP_OVERLAY_RL, FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK).canDrown(true).canSwim(false).canPushEntity(true).rarity(Rarity.EPIC));



    private static RegistryObject<FluidType> register(String name, ResourceLocation overlay,FluidType.Properties properties){
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, overlay,0xA1E038D0, new Vector3f(224f / 255f, 56f / 255f, 208f / 255f), properties));
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
