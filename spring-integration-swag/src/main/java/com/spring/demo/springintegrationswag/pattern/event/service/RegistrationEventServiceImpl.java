package com.spring.demo.springintegrationswag.pattern.event.service;

import com.spring.demo.springintegrationswag.pattern.event.config.EventGateway;
import com.spring.demo.springintegrationswag.pattern.event.model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Service
public class RegistrationEventServiceImpl implements RegistrationEventService
{
    private static final Logger logger = LogManager.getLogger(RegistrationEventServiceImpl.class);

    @Autowired
    private EventGateway eventGateway;

    @Override
    public void notifyObservers(Event event)
    {
        logger.info("Publishing event: {}", event);
        Message<Event> eventMessage = MessageBuilder
                .withPayload(event)
                .setHeader(IntegrationMessageHeaderAccessor.EXPIRATION_DATE,
                        System.currentTimeMillis() + 60 * 60 * 1000)
                .build();
        eventGateway.publishEvent(eventMessage);
    }
}
