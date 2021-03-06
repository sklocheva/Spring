package com.tacos.tacocloud.rest.client;

import com.tacos.tacocloud.model.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sophia Klocheva
 * on 7/31/2020
 */
@Slf4j
@Service
public class IngredientClient
{
    private final RestTemplate restTemplate;

    @Autowired
    public IngredientClient(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public Ingredient getIngredientById(String ingredientId)
    {
        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
                Ingredient.class, ingredientId);
    }

    public Ingredient getIngredientByIdEntity(String ingredientId)
    {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/ingredients/{id}",
                        Ingredient.class, ingredientId);
        log.info("Fetched time: " +
                responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }

    public void updateIngredient(Ingredient ingredient)
    {
        restTemplate.put("http://localhost:8080/ingredients/{id}",
                ingredient,
                ingredient.getId());
    }

    public void deleteIngredient(Ingredient ingredient)
    {
        restTemplate.delete("http://localhost:8080/ingredients/{id}",
                ingredient.getId());
    }

    public Ingredient createIngredient(Ingredient ingredient)
    {
        return restTemplate.postForObject("http://localhost:8080/ingredients",
                ingredient,
                Ingredient.class);
    }

    public Ingredient createIngredientforEntity(Ingredient ingredient)
    {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.postForEntity("http://localhost:8080/ingredients",
                        ingredient,
                        Ingredient.class);
        log.info("New resource created at " +
                responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }
}
