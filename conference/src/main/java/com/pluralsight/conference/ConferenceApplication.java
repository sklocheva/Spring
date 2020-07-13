package com.pluralsight.conference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.logging.Logger;

@SpringBootApplication
public class ConferenceApplication extends SpringBootServletInitializer {
	private static Logger logger = Logger.getLogger(ConferenceApplication.class.getName());

	public static void main(String[] args) {
		logger.info("start app");
		SpringApplication.run(ConferenceApplication.class, args);
	}

}
