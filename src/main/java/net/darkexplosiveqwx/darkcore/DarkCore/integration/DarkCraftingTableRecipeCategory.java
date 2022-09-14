package net.darkexplosiveqwx.darkcore.DarkCore.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.darkexplosiveqwx.darkcore.DarkCore.DarkCore;
import net.darkexplosiveqwx.darkcore.DarkCore.block.ModBlocks;
import net.darkexplosiveqwx.darkcore.DarkCore.recipe.DarkCraftingTableRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DarkCraftingTableRecipeCategory implements IRecipeCategory<DarkCraftingTableRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(DarkCore.MOD_ID, "dark_crafting");
    public final static ResourceLocation TEXTURE = new ResourceLocation(DarkCore.MOD_ID, "textures/gui/dark_crafting_table_gui.png");

    private final IDrawable background;
    private final IDrawable icon;


    public DarkCraftingTableRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.DARK_CRAFTING_TABLE.get()));
    }

    @Override
    public @NotNull RecipeType<DarkCraftingTableRecipe> getRecipeType() {
        return JEIDarkCorePlugin.DARK_CRAFTING_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("gui.darkcore.dark_crafting_table");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DarkCraftingTableRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.INPUT, 55, 15)
                .addIngredients(ForgeTypes.FLUID_STACK, List.of(recipe.getFluid()))
                .setFluidRenderer(64000, false, 16, 61);

        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResultItem());
    }
}
