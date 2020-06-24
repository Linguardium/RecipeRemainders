package mod.linguardium.reciperemainders;

import mod.linguardium.reciperemainders.RecipeHelpers.RecipeRemainderProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class RecipeRemainderTestItem extends Item implements RecipeRemainderProvider {
    public RecipeRemainderTestItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        return new ItemStack(Items.DIAMOND_AXE);
    }
}
