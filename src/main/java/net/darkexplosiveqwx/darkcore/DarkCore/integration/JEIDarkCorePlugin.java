package net.darkexplosiveqwx.darkcore.DarkCore.integration;

import mezz.jei.api.*;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.darkexplosiveqwx.darkcore.DarkCore.MainForge;
import net.darkexplosiveqwx.darkcore.DarkCore.recipe.DarkCraftingTableRecipe;
import net.darkexplosiveqwx.darkcore.DarkCore.recipe.GemInfusingStationRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIDarkCorePlugin implements IModPlugin {


    public static RecipeType<GemInfusingStationRecipe> INFUSION_TYPE = new RecipeType<>(GemInfusingStationRecipeCategory.UID, GemInfusingStationRecipe.class);
    public static RecipeType<DarkCraftingTableRecipe> DARK_CRAFTING_TYPE = new RecipeType<>(DarkCraftingTableRecipeCategory.UID, DarkCraftingTableRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(MainForge.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                GemInfusingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                DarkCraftingTableRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }


    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<GemInfusingStationRecipe> recipesInfusing = rm.getAllRecipesFor(GemInfusingStationRecipe.Type.INSTANCE);
        registration.addRecipes(INFUSION_TYPE, recipesInfusing);
        List<DarkCraftingTableRecipe> recipesDarkCrafting = rm.getAllRecipesFor(DarkCraftingTableRecipe.Type.INSTANCE);
        registration.addRecipes(DARK_CRAFTING_TYPE, recipesDarkCrafting);
    }
}

