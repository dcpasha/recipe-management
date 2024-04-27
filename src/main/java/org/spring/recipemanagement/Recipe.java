package org.spring.recipemanagement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.concurrent.atomic.AtomicInteger;

@Document("recipeitems") //  to specify the collection name that will be used by the model.
public class Recipe {
    // This is our model

    private static final AtomicInteger count = new AtomicInteger(0);

//    @Id // to specify the primary key for DB
//    private int id;
    private String title;
    private int cookTime;
    private Boolean vegan;
//    private String ingredients;

//    private int score;
//    private String notes;
//    private String instructions;
//    private int prepTime;
//    private String category;
    private String cuisine;

    public Recipe() {
    }

    public Recipe(String name, int cookTime, Boolean vegan, String cuisine) {
        this.title = name;
        this.cuisine = cuisine;
        this.cookTime = cookTime;
        this.vegan = vegan;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }


    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

//    public String getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(String ingredients) {
//        this.ingredients = ingredients;
//    }

    @Override
    public String toString() {
        return "Recipe{" +
                ", title='" + title + '\'' +
                ", cookTime=" + cookTime +
                ", vegan=" + vegan +
//                ", ingredients='" + ingredients + '\'' +
                ", cuisine='" + cuisine + '\'' +
                '}';
    }
}
