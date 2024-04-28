package org.spring.recipemanagement;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class RecipeManagementController {

    @Autowired
    RecipeItemRepository recipeItemRepo;
    @Autowired
    CustomRecipeItemRepositoryImp customRecipeItemRepo;

//    List<Recipe> recipeList = new ArrayList<>();
//    Map<Integer, Recipe> recipeMap = new HashMap<>();
    Gson gson = new Gson();  // to serialize and deserialize

    @GetMapping("/home")
    public String getHome(){
        return gson.toJson("Hakuna Matata");
    }

    @PostMapping("/add") // adds a new recipe to list
    public String addRecipe(@RequestBody Recipe recipe){
        recipeItemRepo.save(recipe); // save recipe to db
        return String.format(recipe.getTitle() + " was added");
    }

    @GetMapping("/recipes") // returns all recipes
    public String returnAllRecipes(){
        List<Recipe> recipes = recipeItemRepo.findAll();
        return gson.toJson(recipes);
    }

    @GetMapping("/recipes/cuisine")  // return all recipes from a certain cuisine
    // @RequestParam to accept query parameters//
    public ResponseEntity<String> returnRecipeByCuisine(@RequestParam(required = false) String type) {
        List<Recipe> recipes = recipeItemRepo.findRecipesByCuisine(type);  // list with all recipes of a certain type
        return ResponseEntity.ok(gson.toJson(recipes));
    }

    @GetMapping("/recipes/title")  // return a recipes by its name
    // Assume that each recipe title is unique
    // @RequestParam to accept query parameters
    public ResponseEntity<String> returnRecipeByTitle(@RequestParam(required = false) String name) {
        List<Recipe> recipe = recipeItemRepo.findRecipesByTitle(name);  // list with all recipes of a certain type
        return ResponseEntity.ok(gson.toJson(recipe));
    }


    @GetMapping("/recipe") // return recipe by id
    public ResponseEntity<String> getRecipeById(@RequestParam(required = false) String id) {
        return ResponseEntity.ok(gson.toJson(
                recipeItemRepo.findById(id).orElse(null)
        ));
    }

    @PutMapping("/recipe") // update the cuisine field of the specified recipe by id
    public ResponseEntity<String> updateRecipeById(@RequestParam String id, @RequestParam String cuisine) {
        customRecipeItemRepo.updateRecipeCuisine(id, cuisine);
        return ResponseEntity.ok(gson.toJson(id + " and " + cuisine));
    }


    @DeleteMapping("/remove")  // delete a recipe by id if exists and displays the recipe title
    public String deleteRecipeById(@RequestParam(required = false) String id){
       Optional<Recipe> recipe = recipeItemRepo.findById(id);
       String message;
       if (recipe.isPresent()) {
           String title = recipe.get().getTitle(); // extract the title
           message = "Removed \"" + title + "\" from recipes";
           recipeItemRepo.deleteById(id);
       }
       else {
           message = id + " ID does not exist";
       }
        return message; // with the title of the recipe if exists
    }

    @DeleteMapping("/remove/all")  // delete all recipes
    public String deleteRecipeByTitle(){
        recipeItemRepo.deleteAll();
        return "All Recipes were deleted";
    }

    // todo: exception handling

} // end RecipeManagementController
