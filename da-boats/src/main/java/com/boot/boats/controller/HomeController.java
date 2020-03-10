package com.boot.boats.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sophia Klocheva
 * on 2/17/2020
 */
@RestController
public class HomeController
{
    @RequestMapping("/")
    public String home()
    {
        return "Boot response massage";
    }
}
