package com.boot.boats;


import com.boot.boats.controller.HomeController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sophia Klocheva
 * on 2/18/2020
 */
public class DaBoatsTest
{
    @Test
    public void main()
    {
        HomeController homeController = new HomeController();
        String result = homeController.home();
        assertEquals(result, "Boot response massage");
    }
}