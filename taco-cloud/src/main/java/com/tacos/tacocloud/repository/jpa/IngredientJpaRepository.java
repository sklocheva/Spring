package com.tacos.tacocloud.repository.jpa;

import com.tacos.tacocloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sophia Klocheva
 * on 7/20/2020
 */
public interface IngredientJpaRepository extends CrudRepository<Ingredient, String>
{
}
