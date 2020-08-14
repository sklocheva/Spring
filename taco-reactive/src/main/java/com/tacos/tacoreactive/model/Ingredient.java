package com.tacos.tacoreactive.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author Sophia Klocheva
 * on 7/13/2020
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient
{
    private final String id;
    private final String name;

    private final Type type;

    public static enum Type
    {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
