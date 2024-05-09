package eu.piiroinen.recipes.controller;

import eu.piiroinen.recipes.model.RecipeCategory;
import eu.piiroinen.recipes.repository.RecipeCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@RequestMapping("/categories")
@Controller
public class RecipeCategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(RecipeCategoryController.class);

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @GetMapping("/all")
    public ResponseEntity<Map<String, List<RecipeCategory>>> getAllCategories() {
        try {
            List<RecipeCategory> categories = this.recipeCategoryRepository.findAll();
            Map<String, List<RecipeCategory>> response = new HashMap<>();
            response.put("categories", categories);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            LOG.error("An exception occurred in RecipeCategoryController: ", e);
            Map<String, List<RecipeCategory>> emptyResponse = new HashMap<>();
            emptyResponse.put("categories", new ArrayList<>());
            return ResponseEntity.status(500)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }

    @GetMapping("/recipes")
    public ResponseEntity<Map<String, List<RecipeCategory>>> getRecipesForCategory(
            @RequestParam(name="recipeCategoryId") Long recipeCategoryId) {
        try {
            List<RecipeCategory> categories = this.recipeCategoryRepository.findRecipesByRecipeCategoryIdOrderByRecipeName(recipeCategoryId);
            Map<String, List<RecipeCategory>> response = new HashMap<>();
            response.put("recipesByCategory", categories);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            LOG.error("An exception occurred in RecipeCategoryController: ", e);
            Map<String, List<RecipeCategory>> emptyResponse = new HashMap<>();
            emptyResponse.put("recipesByCategory", new ArrayList<>());
            return ResponseEntity.status(500)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }
}
