package com.spel.demo.model;

import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 8/26/2020
 */
@Component("city")
public class City
{
    private String name;
    private double shipping;
    private Boolean isCapital;

    public City()
    {
    }

    public City(String name, double shipping, Boolean isCapital)
    {
        this.name = name;
        this.shipping = shipping;
        this.isCapital = isCapital;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getShipping()
    {
        return shipping;
    }

    public void setShipping(double shipping)
    {
        this.shipping = shipping;
    }

    public Boolean getIsCapital()
    {
        return isCapital;
    }

    public void setIsCapital(Boolean capital)
    {
        isCapital = capital;
    }
}
