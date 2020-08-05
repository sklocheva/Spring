package com.pluralsight.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import java.util.logging.Logger;

@Controller
public class GreetingController
{

    private static Logger logger = Logger.getLogger(GreetingController.class.getName());

    @GetMapping("/greeting")
    public String greeting(Map<String, Object> model)
    {
        logger.info("GreetingController");
        model.put("message", "Hello Bryan");
        logger.info("GreetingController put");
        return "greeting";
    }
}
