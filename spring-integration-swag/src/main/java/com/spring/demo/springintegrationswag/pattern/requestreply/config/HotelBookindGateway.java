package com.spring.demo.springintegrationswag.pattern.requestreply.config;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@MessagingGateway(name = "hotelBookingGateway", defaultRequestChannel = "hotelBookingChannel")
public interface HotelBookindGateway
{
    @Gateway
    Message<Boolean> checkAvailability(Message<Integer> numberOfGuests);
}
