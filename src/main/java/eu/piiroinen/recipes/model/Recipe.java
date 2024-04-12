import com.sun.org.apache.bcel.internal.generic.Instruction;

import java.util.ArrayList;

class Recipe {

        ArrayList<Ingredient> ingredients;
        ArrayList<Instruction> instructions;
        ArrayList<RecipeCategory> categories;
        String recipeImageUrl;

    public Recipe(ArrayList<Ingredient> ingredients, ArrayList<Instruction> instructions, ArrayList<RecipeCategory> categories, String recipeImageUrl) {
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.categories = categories;
        this.recipeImageUrl = recipeImageUrl;
    }
}