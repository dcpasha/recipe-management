package org.spring.recipemanagement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.concurrent.atomic.AtomicInteger;

@Document("recipeitems") //  to specify the collection name that will be used by the model.
public class Recipe {
    // This is our model

    private static final AtomicInteger count = new AtomicInteger(0);

    @Id // to specify the primary key for DB
    private final int id;
    private String name;
    private int cookTime;
    private Boolean vegan;
    private String ingredients;
    public int getId() {
        return id;
    }

//    private int score;
//    private String notes;
//    private String instructions;
//    private int prepTime;
//    private String category;


    public Recipe() {
        this.id = count.incrementAndGet();
    }

    public Recipe(String name, int cookTime, Boolean vegan) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.cookTime = cookTime;
        this.vegan = vegan;
    }

    private String cuisine;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }


}
