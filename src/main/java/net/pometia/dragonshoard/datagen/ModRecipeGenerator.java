package net.pometia.dragonshoard.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.pometia.dragonshoard.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {

//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_BLOCK)
//                .pattern("SSS")
//                .pattern("SSS")
//                .pattern("SSS")
//                .input('S', ModItems.SILVER_INGOT)

    }
}
