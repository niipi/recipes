package eu.piiroinen.recipes.repository;

import eu.piiroinen.recipes.model.Recipe;
import eu.piiroinen.recipes.model.RecipeCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findById(Long recipeId);

    Optional<List<RecipeCategory>> findCategoriesByRecipeId(Long recipeId);

    List<Recipe> findRecipesBySeason(String season);

    // TODO: Create, update, delete

}
