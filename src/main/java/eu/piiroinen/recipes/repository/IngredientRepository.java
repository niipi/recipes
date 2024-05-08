package eu.piiroinen.recipes.repository;

import eu.piiroinen.recipes.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    List<Ingredient> findIngredientsByRecipeId(Long recipeId);

    // TODO: Create, Update, Delete

}
