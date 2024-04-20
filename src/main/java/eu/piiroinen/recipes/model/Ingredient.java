package eu.piiroinen.recipes.model;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class Ingredient {

    String amount;
    String ingredientName;

    public Ingredient() {}

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Ingredient(String amount, String ingredientName) {
        this.amount = amount;
        this.ingredientName = ingredientName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}