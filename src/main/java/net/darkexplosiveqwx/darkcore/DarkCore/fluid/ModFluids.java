package net.darkexplosiveqwx.darkcore.DarkCore.fluid;


import net.darkexplosiveqwx.darkcore.DarkCore.Main;
import net.darkexplosiveqwx.darkcore.DarkCore.block.ModBlocks;
import net.darkexplosiveqwx.darkcore.DarkCore.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.*;

public class ModFluids{
    public static final DeferredRegister<Fluid> FLUIDS =DeferredRegister.create(ForgeRegistries.FLUIDS, Main.MOD_ID);


    public static final RegistryObject<FlowingFluid> SOURCE_SOAP_WATER = FLUIDS.register("soap_water_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.SOAP_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_SOAP_WATER = FLUIDS.register("flowing_soap_water", () -> new ForgeFlowingFluid.Flowing(ModFluids.SOAP_WATER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties SOAP_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidsTypes.SOAP_WATER_FLUID_TYPE, SOURCE_SOAP_WATER, FLOWING_SOAP_WATER).slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.SOAP_WATER_BLOCK).bucket(ModItems.SOAP_WATER_BUCKET);


    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}
