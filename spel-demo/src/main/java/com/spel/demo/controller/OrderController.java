package com.spel.demo.controller;

import com.spel.demo.model.City;
import com.spel.demo.model.Order;
import com.spel.demo.model.Shipping;
import com.spel.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sophia Klocheva
 * on 8/26/2020
 */
@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private City city;

    @Autowired
    private Shipping shipping;

    @Autowired
    private Order order;

    @Autowired
    private User user;

    @GetMapping("/customer")
    public String getCustomer()
    {
        return user.getName();
    }

    @GetMapping("/shipping/locations")
    public List<City> getShippingLocations()
    {
        return order.getShippingLocations();
    }
}
