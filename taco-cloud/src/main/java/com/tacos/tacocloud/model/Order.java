package com.tacos.tacocloud.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Sophia Klocheva
 * on 7/14/2020
 */
@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date placedAt;
    @NotBlank(message = "Name must not be empty")
    private String name;
    @NotBlank(message = "street must not be empty")
    private String street;
    @NotBlank(message = "city must not be empty")
    private String city;
    private String state;
    @NotBlank(message = "zip must not be empty")
    private String zip;
    @CreditCardNumber(message = "Credit card number must be valid")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;
    @NotEmpty
    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos;

    @ManyToOne
    private Users user;

    @PrePersist
    void placedAt()
    {
        this.placedAt = new Date();
    }
}
