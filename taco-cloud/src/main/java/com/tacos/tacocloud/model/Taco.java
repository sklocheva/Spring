package com.tacos.tacocloud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import javax.persistence.*;
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
@Entity
@RestResource(rel = "tacos", path = "tacos")
public class Taco
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotBlank
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @NotEmpty
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany(targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt()
    {
        this.createdAt = new Date();
    }
}
