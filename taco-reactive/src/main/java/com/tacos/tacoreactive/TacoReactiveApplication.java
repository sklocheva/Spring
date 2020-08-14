package com.tacos.tacoreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tacos.tacoreactive")
public class TacoReactiveApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(TacoReactiveApplication.class, args);
    }

}
