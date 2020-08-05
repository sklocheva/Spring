package com.tacos.tacocloud.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Sophia Klocheva
 * on 7/28/2020
 */
@Component
@Data
@Validated
//creates properties to be set like fields
@ConfigurationProperties(prefix="taco.orders")
public class OrderProps
{
    @Min(value=5, message="must be between 5 and 25")
    @Max(value=25, message="must be between 5 and 25")
    private int pageSize;
}
