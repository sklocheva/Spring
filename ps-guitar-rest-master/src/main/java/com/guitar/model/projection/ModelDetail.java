package com.guitar.model.projection;

import com.guitar.model.Manufacturer;
import com.guitar.model.Model;
import com.guitar.model.ModelType;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * @author Sophia Klocheva
 * on 3/10/2020
 */
@Projection(name = "modelDetail", types = {Model.class})
public interface ModelDetail
{
    String getName();
    BigDecimal getPrice();
    Manufacturer getManufacturer();
    ModelType getModelType();
    int getFrets();
    String getWoodType();

}
