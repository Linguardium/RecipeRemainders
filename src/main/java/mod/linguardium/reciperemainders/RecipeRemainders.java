package mod.linguardium.reciperemainders;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RecipeRemainders implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "reciperemainders";
    public static final String MOD_NAME = "Recipe Remainders";
    public static final RecipeRemainderTestItem TESTITEM = Registry.register(Registry.ITEM,new Identifier(MOD_ID,"testitem"),new RecipeRemainderTestItem(new Item.Settings()));

    @Override
    public void onInitialize() {
        LOGGER.info("test2");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}