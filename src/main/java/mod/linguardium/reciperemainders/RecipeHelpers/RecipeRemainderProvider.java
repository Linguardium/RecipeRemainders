package mod.linguardium.reciperemainders.RecipeHelpers;

import net.minecraft.item.ItemStack;

public interface RecipeRemainderProvider
{
    public ItemStack getRecipeRemainder(ItemStack stack);
}
