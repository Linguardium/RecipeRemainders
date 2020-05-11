package mod.linguardium.customrecipes.mixins;

import mod.linguardium.customrecipes.RecipeHelpers.CustomRecipeRemainder;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = {ShapelessRecipe.class, ShapedRecipe.class, SpecialCraftingRecipe.class})
public abstract class RecipeRemainderMixin implements CraftingRecipe {

    @Override
    public DefaultedList<ItemStack> getRemainingStacks(CraftingInventory inventory) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.getInvSize(), ItemStack.EMPTY);

        for(int i = 0; i < defaultedList.size(); ++i) {
            Item item = inventory.getInvStack(i).getItem();
            if (item.hasRecipeRemainder()) {
                    defaultedList.set(i, new ItemStack(item.getRecipeRemainder()));
            }else if (item instanceof CustomRecipeRemainder) {
                    defaultedList.set(i,((CustomRecipeRemainder) item).getRecipeRemainder(inventory.getInvStack(i)));
            }
        }

        return defaultedList;
    }

}
