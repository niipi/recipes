package eu.piiroinen.recipes.controller;

import eu.piiroinen.recipes.model.Recipe;
import eu.piiroinen.recipes.model.RecipeCategory;
import eu.piiroinen.recipes.testdata.FrontendTestCategoryGenerator;
import eu.piiroinen.recipes.testdata.FrontendTestRecipeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FrontendTestController {

    private static final Logger LOG = LoggerFactory.getLogger(FrontendTestController.class);

    private FrontendTestRecipeGenerator testRecipeGenerator = new FrontendTestRecipeGenerator();

    private FrontendTestCategoryGenerator testCategoryGenerator = new FrontendTestCategoryGenerator();

    @CrossOrigin(origins="https://localhost:3000", allowedHeaders = "*")
    @RequestMapping(value="/frontendtest")
    public ResponseEntity<Map<String, List<Recipe>>> getTestRecipeListing() {
        try {
            Map<String, List<Recipe>> response = new HashMap<>();

            List<Recipe> recipes = testRecipeGenerator.generateTestRecipeListing();
            response.put("recipes", recipes);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Response body contains the following recipes:");
                for (Recipe recipe : recipes) {
                    LOG.debug(recipe.getName());
                }
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            LOG.error("An exception occurred.", e);
            Map<String, List<Recipe>> emptyResponse = new HashMap<>();
            return ResponseEntity.badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }

    @CrossOrigin(origins="https://localhost:3000", allowedHeaders = "*")
    @RequestMapping(value="/frontendcategorytest")
    public ResponseEntity<Map<String, List<RecipeCategory>>> getTestCategoryListing() {
        try {
            Map<String, List<RecipeCategory>> response = new HashMap<>();

            List<RecipeCategory> categories = testCategoryGenerator.generateTestRecipeCategoryList();
            response.put("categories", categories);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Response body contains the following recipe categories:");
                for (RecipeCategory category : categories) {
                    LOG.debug(category.getRecipeCategoryName());
                }
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            LOG.error("An exception occurred.", e);
            Map<String, List<RecipeCategory>> emptyResponse = new HashMap<>();
            return ResponseEntity.badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }
        
}