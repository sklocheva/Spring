package com.pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ImportResource("classpath:/integration-config.xml")
public class SpringIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

}
