package eu.piiroinen.recipes.model;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public class Recipe {

        String name;
        List<Ingredient> ingredients;
        List<Instruction> instructions;
        List<RecipeCategory> categories;
        String recipeImageUrl;

    public Recipe(String name, List<Ingredient> ingredients, List<Instruction> instructions, List<RecipeCategory> categories, String recipeImageUrl) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.categories = categories;
        this.recipeImageUrl = recipeImageUrl;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public String getRecipeImageUrl() {
        return recipeImageUrl;
    }
}