package eu.piiroinen.recipes.repository;

import eu.piiroinen.recipes.model.Recipe;
import eu.piiroinen.recipes.model.RecipeCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Long> {

    List<RecipeCategory> findAll();

    @Query(value = "select * from kategoriat where id_kategoria in (select id_kategoria from reseptin_kategoria where id_resepti = ?1)",
    nativeQuery = true)
    Optional<List<RecipeCategory>> findCategoriesByCategoriesForRecipe(Long recipeId);

    // TODO: Create, update, delete

}
