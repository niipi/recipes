package eu.piiroinen.recipes.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;


@Entity
@Table(name="kategoriat")
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kategoria")
    private Long recipeCategoryId;
    @NotNull
    @Column(name="nimi", length = 50, nullable = false)
    private String recipeCategoryName;
    @ManyToMany(mappedBy = "categoriesForRecipe")
    @JsonIgnore
    public Set<Recipe> categoriesForRecipe;

    public RecipeCategory(String recipeCategoryName) {
        this.recipeCategoryName = recipeCategoryName;
    }

    public RecipeCategory() {}

    public Long getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public String getRecipeCategoryName() {
        return recipeCategoryName;
    }

    public void setRecipeCategoryName(String recipeCategoryName) {
        this.recipeCategoryName = recipeCategoryName;
    }
}