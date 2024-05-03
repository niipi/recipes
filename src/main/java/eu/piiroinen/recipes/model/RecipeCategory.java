package eu.piiroinen.recipes.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="kategoriat")
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kategoria")
    private Long recipeCategoryId;
    @Column(name="nimi", length = 50, nullable = false)
    private String recipeCategoryName;
    @ManyToMany
    @JoinTable(name = "reseptin_kategoria", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_kategoria"))
    Set<Recipe> recipesForCategory;

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