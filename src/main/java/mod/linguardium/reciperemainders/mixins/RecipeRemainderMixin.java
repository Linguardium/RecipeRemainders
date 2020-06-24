package mod.linguardium.reciperemainders.mixins;

import com.google.gson.Gson;
import mod.linguardium.reciperemainders.RecipeHelpers.RecipeRemainderProvider;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(RecipeManager.class)
public abstract class RecipeRemainderMixin extends JsonDataLoader {

    public RecipeRemainderMixin(Gson gson, String dataType) {
        super(gson, dataType);
    }
    @Inject(at=@At(value="RETURN",ordinal=0),method="getRemainingStacks", cancellable = true)
    private <C extends Inventory, T extends Recipe<C>> void RecipeRemainders_getRecipeRemainders(RecipeType<T> recipeType, C inventory, World world, CallbackInfoReturnable<DefaultedList<ItemStack>> info) {
        DefaultedList<ItemStack> retList = info.getReturnValue();
        for(int i = 0; i < inventory.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            if (stack.getItem() instanceof RecipeRemainderProvider) {
                retList.set(i, ((RecipeRemainderProvider)stack.getItem()).getRecipeRemainder(stack));
            }
        }
        info.setReturnValue(retList);
    }

}
