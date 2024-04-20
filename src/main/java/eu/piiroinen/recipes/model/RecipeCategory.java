package eu.piiroinen.recipes.model;


import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class RecipeCategory {

    private int recipeCategoryId;
    private String recipeCategoryName;

    public RecipeCategory(String recipeCategoryName) {
        this.recipeCategoryName = recipeCategoryName;
    }

    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public String getRecipeCategoryName() {
        return recipeCategoryName;
    }

    public void setRecipeCategoryName(String recipeCategoryName) {
        this.recipeCategoryName = recipeCategoryName;
    }
}