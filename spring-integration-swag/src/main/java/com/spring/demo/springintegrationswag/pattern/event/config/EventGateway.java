package com.spring.demo.springintegrationswag.pattern.event.config;

import com.spring.demo.springintegrationswag.pattern.event.model.Event;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@MessagingGateway(name = "eventGateway", defaultRequestChannel = "eventChannel")
public interface EventGateway
{
    @Gateway
    void publishEvent(Message<Event> eventMessage);
}
