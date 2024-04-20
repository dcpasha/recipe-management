package org.spring.recipemanagement;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RecipeManagementController {

    List<Recipe> recipeList = new ArrayList<>();
    Gson gson = new Gson();  // to serialize and deserialize

    @GetMapping("/home")
    public String getHome(){
        return gson.toJson("Hakuna Matata");
    }

    @PostMapping("/add") // to add a new recipe to list
    public String addRecipe(@RequestBody Recipe recipe){
        recipeList.add(recipe);
        return String.format(recipe.getName() + " was added");
    }

    @GetMapping("/recipes")
    public String returnAllRecipes(){
        return gson.toJson(recipeList);
    }

    @DeleteMapping("/remove")
    public void deleteAllRecipes(){
        recipeList = new ArrayList<>();
    }

    // todo: delete a recipe by name/id
    // todo: edit a recipe by name/id
    // todo: exception handling
    // todo: ensure that the "required" fields are provided
    // todo: databased persisted
    // todo increment recipe id automatically - insure that the id is unique

} // end RecipeManagementController
