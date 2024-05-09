package eu.piiroinen.recipes.repository;

import eu.piiroinen.recipes.model.RecipeCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Long> {

    List<RecipeCategory> findAll();

    // Categories to be returned for a single recipe, implementation will give always alphabetical listing
    List<RecipeCategory> findRecipesByRecipeCategoryIdOrderByRecipeName(Long recipeCategoryId);

    // TODO: Create, update, delete

}
