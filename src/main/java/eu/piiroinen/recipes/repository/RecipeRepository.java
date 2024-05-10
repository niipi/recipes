package eu.piiroinen.recipes.repository;

import eu.piiroinen.recipes.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findById(Long recipeId);

    // Recipes to be returned for a single category, implementation will give always alphabetical listing
     @Query(
           value = "select * from resepti where id_resepti in (select id_resepti from reseptin_kategoria where id_kategoria = ?1)",
         nativeQuery = true)
     Set<Recipe> findByCategoriesForRecipeOrderByRecipeName(Long recipeCategoryId);

    List<Recipe> findRecipesBySeasonOrderByRecipeName(String season);

    Optional<List<Recipe>> findRecipesByIsFavouriteIsTrueOrderByRecipeName();

    // TODO: Create, update, delete

}
