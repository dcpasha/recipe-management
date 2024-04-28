package org.spring.recipemanagement;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component // allows sprint to detect our custom bean
public class CustomRecipeItemRepositoryImp implements CustomRecipeItemRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateRecipeCuisine(String key, String newCuisine) {
        Criteria criteria = Criteria.where("id").is(key);
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("cuisine", newCuisine);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Recipe.class);

        System.out.println(result.getMatchedCount() + " records(s) updated");
    }
}
