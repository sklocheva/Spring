package com.tacos.tacoreactive.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author Sophia Klocheva
 * on 7/13/2020
 */
@Data
@NoArgsConstructor
public class Taco
{
    private Long id;

    private Date createdAt;

    @NotBlank
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @NotEmpty
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    void createdAt()
    {
        this.createdAt = new Date();
    }
}
