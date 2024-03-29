package net.darkexplosiveqwx.darkcore.DarkCore.recipe;

import net.darkexplosiveqwx.darkcore.DarkCore.DarkCore;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DarkCore.MOD_ID);

    public static final RegistryObject<RecipeSerializer<GemInfusingStationRecipe>> GEM_INFUSING_SERIALIZER =
            SERIALIZERS.register("gem_infusing", () -> GemInfusingStationRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<DarkCraftingTableRecipe>> DARK_CRAFTING_SERIALIZER =
            SERIALIZERS.register("dark_crafting", () -> DarkCraftingTableRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
