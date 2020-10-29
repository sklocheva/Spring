package com.spring.demo.springintegrationswag.pattern.command.model;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
public class Swag
{
    private String type;
    private String amaunt;

    public Swag(String type)
    {
        this.type = type;
    }

    public String getAmaunt()
    {
        return amaunt;
    }

    public void setAmaunt(String amaunt)
    {
        this.amaunt = amaunt;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "Swag{" +
                "type='" + type + '\'' +
                '}';
    }
}
