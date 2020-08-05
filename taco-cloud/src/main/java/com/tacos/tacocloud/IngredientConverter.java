package com.tacos.tacocloud;

import com.tacos.tacocloud.model.Ingredient;
import com.tacos.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sophia Klocheva
 * on 7/17/2020
 * <p>
 * Converts the String ingredient from thymeleaf to Ingredient.
 */
@Component
public class IngredientConverter implements Converter<String, Ingredient>
{
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientConverter(IngredientRepository ingredientRepository)
    {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String source)
    {
        List<Ingredient> ingredients = new ArrayList<>();

        ingredientRepository.findAll().forEach(i -> ingredients.add(i));

        for (Ingredient ingredient : ingredients)
        {

            if (ingredient.getId().equals(source))
                return ingredient;
        }
        return null;
    }
}
