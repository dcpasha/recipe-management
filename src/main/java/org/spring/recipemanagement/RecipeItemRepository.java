package org.spring.recipemanagement;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/*
 The API implementation happens in the repository.
 It acts as a link between the model and the database and has all the methods for CRUD operations.
  */

public interface RecipeItemRepository extends MongoRepository <Recipe, String> {

    @Query(value="{cuisine:'?0'}", fields="{" +
            "'_id': 1," +
            " 'title': 1, 'cuisine': 1, 'cookTime': 1, 'vegan': 1}")
    List<Recipe> findRecipesByCuisine(String cuisine);

    @Query(value="{title:'?0'}", fields="{" +
            "'_id': 1," +
            " 'title': 1, 'cuisine': 1, 'cookTime': 1, 'vegan': 1}")
    List<Recipe> findRecipesByTitle(String title);

//    @Query(value="{_id:'?0'}", fields="{'title': 1}")
//    Recipe findRecipeById(String _id);
    public long count(); // count the number of documents in a collection
}
