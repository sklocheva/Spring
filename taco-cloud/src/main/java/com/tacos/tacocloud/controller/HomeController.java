package com.tacos.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Sophia Klocheva
 * on 7/9/2020
 */
@Controller
public class HomeController
{
    @GetMapping("/")
    public String home()
    {
        return "home";
    }
}
