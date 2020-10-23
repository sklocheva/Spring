package com.spring.demo.springintegrationswag;

import com.spring.demo.springintegrationswag.pattern.command.service.RegistrationService;
import com.spring.demo.springintegrationswag.pattern.document.model.ReservationRecord;
import com.spring.demo.springintegrationswag.pattern.document.service.RegistrationRecordService;
import com.spring.demo.springintegrationswag.pattern.event.model.Event;
import com.spring.demo.springintegrationswag.pattern.event.service.RegistrationEventService;
import com.spring.demo.springintegrationswag.pattern.requestreply.service.RegistrationBookingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringIntegrationSwagApplication implements CommandLineRunner
{

    private static final Logger logger = LogManager.getLogger(SpringIntegrationSwagApplication.class);

//    @Autowired
//    private RegistrationService service;
//
//    @Autowired
//    private RegistrationRecordService recordService;
//
//    @Autowired
//    private RegistrationBookingService bookingService;

    @Autowired
    private RegistrationEventService eventService;


    public static void main(String[] args)
    {
        SpringApplication.run(SpringIntegrationSwagApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception
    {
        //command message pattern execution
//        service.commit("869587");

        //document message pattern execution
//        recordService.updateReservationRecord(new ReservationRecord("Person A", new Date()));

        //request-reply message pattern execution
//        Boolean availability = bookingService.checkAvailability(5);
//        logger.info("Hotel availability for 5 guests {}", availability);

        //event message pattern execution
        eventService.notifyObservers(new Event("Event1", "new event"));
    }
}
