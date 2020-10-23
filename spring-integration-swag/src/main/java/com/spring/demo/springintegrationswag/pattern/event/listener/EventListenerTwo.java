package com.spring.demo.springintegrationswag.pattern.event.listener;

import com.spring.demo.springintegrationswag.pattern.event.model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Service
public class EventListenerTwo
{
    private static final Logger logger = LogManager.getLogger(EventListenerTwo.class);

    @ServiceActivator(inputChannel = "eventChannel")
    public void receiveEvent(Message<Event> eventMessage)
    {
        IntegrationMessageHeaderAccessor headerAccessor = new IntegrationMessageHeaderAccessor(eventMessage);
        logger.info("Event Listener TWO message header: {}", headerAccessor.getExpirationDate());
        logger.info("Event Listener TWO Payload message: {}", eventMessage.getPayload());
    }
}
