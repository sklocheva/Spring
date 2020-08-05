package com.tacos.tacocloud.rest.hyperlink;

import com.tacos.tacocloud.model.Ingredient;
import com.tacos.tacocloud.model.Taco;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

/**
 * @author Sophia Klocheva
 * on 7/30/2020
 */
public class ResourceTaco extends RepresentationModel
{
    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final List<Ingredient> ingredients;

    public ResourceTaco(Taco taco)
    {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = taco.getIngredients();
    }

}
