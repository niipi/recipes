package eu.piiroinen.recipes.model;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public class Recipe {

        List<Ingredient> ingredients;
        List<Instruction> instructions;
        List<RecipeCategory> categories;
        String recipeImageUrl;

    public Recipe(List<Ingredient> ingredients, List<Instruction> instructions, List<RecipeCategory> categories, String recipeImageUrl) {
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.categories = categories;
        this.recipeImageUrl = recipeImageUrl;
    }
}