package com.spel.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Sophia Klocheva
 * on 8/26/2020
 */
@Component("order")
public class Order
{
    @Value("#{100.55 + 500.75 * 10}")
    private double amount;
    @Value("#{order.amount >= 100 ? order.amount * 5/100 : 0}")
    private double discount;
    @Value("#{user.country == 'US' ? 3 : 14}")
    private int daysToDeliver;
    @Value("#{user.country}")
    private String origin;
    @Value("#{T(java.text.NumberFormat).getCurrencyInstance(T(java.util.Locale).getDefault())}")
    private String formattedAmount;
    @Value("#{shipping.locationsByCountry[user.country]}")
    private List<City> shippingLocations;

    public List<City> getShippingLocations()
    {
        return shippingLocations;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public double getDiscount()
    {
        return discount;
    }

    public void setDiscount(double discount)
    {
        this.discount = discount;
    }

    public int getDaysToDeliver()
    {
        return daysToDeliver;
    }

    public void setDaysToDeliver(int daysToDeliver)
    {
        this.daysToDeliver = daysToDeliver;
    }

    public String getOrigin()
    {
        return origin;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getFormattedAmount()
    {
        return formattedAmount;
    }

    public void setFormattedAmount(String formattedAmount)
    {
        this.formattedAmount = formattedAmount;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "amount=" + amount +
                ", discount=" + discount +
                ", daysToDeliver=" + daysToDeliver +
                ", origin='" + origin + '\'' +
                '}';
    }
}
