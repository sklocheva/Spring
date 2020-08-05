package com.tacos.tacocloud.repository;

import com.tacos.tacocloud.model.Ingredient;

/**
 * @author Sophia Klocheva
 * on 7/16/2020
 */
public interface IngredientRepository
{
    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);

}
