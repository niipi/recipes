package eu.piiroinen.recipes.repository;

import eu.piiroinen.recipes.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    // Confirm with the team if both alphabetical and unordered implementation are needed
    List<Recipe> findCategoriesByRecipeId(Long recipeId);

    // TODO: Create, update, delete

}
