package eu.piiroinen.recipes.repository;

import eu.piiroinen.recipes.model.RecipeCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Long> {

    Set<RecipeCategory> findAll();

    @Query(value = "select * from kategoriat where id_kategoria in (select id_kategoria from reseptin_kategoria where id_resepti = ?1)",
    nativeQuery = true)
    Optional<Set<RecipeCategory>> findCategoriesByCategoriesForRecipe(Long recipeId);

    // TODO: Create, update, delete

}
