package com.spring.demo.springintegrationswag.pattern.requestreply.endpoint;

import org.springframework.messaging.Message;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
public interface HotelBookingService
{
    Message<Boolean> checkAvailability(Message<Integer> numberOfGuests);
}
