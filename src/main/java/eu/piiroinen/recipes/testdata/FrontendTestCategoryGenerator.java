package eu.piiroinen.recipes.testdata;

import eu.piiroinen.recipes.model.RecipeCategory;

import java.util.ArrayList;
import java.util.List;

public class FrontendTestCategoryGenerator {

    public List<RecipeCategory> generateTestRecipeCategoryList() {
        ArrayList<RecipeCategory> categories = new ArrayList<>();
        String[] categoryNames = {"Kana", "Liha", "Kala", "Kasvis", "Leivonta"};

        for (String name : categoryNames) {
            categories.add(new RecipeCategory(name));
        }

        return categories;
    }
}
