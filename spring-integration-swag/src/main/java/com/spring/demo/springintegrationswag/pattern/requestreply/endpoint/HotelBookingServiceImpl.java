package com.spring.demo.springintegrationswag.pattern.requestreply.endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Service
@MessageEndpoint
public class HotelBookingServiceImpl implements HotelBookingService
{
    private static final Logger logger = LogManager.getLogger(HotelBookingServiceImpl.class);

    @ServiceActivator(inputChannel = "hotelBookingChannel")
    @Override
    public Message<Boolean> checkAvailability(Message<Integer> numberOfGuests)
    {
        logger.info("Receiving message {} ", numberOfGuests);
        numberOfGuests.getHeaders().entrySet()
                .forEach(stringObjectEntry -> logger.info("Header: {}: {}",
                        stringObjectEntry.getKey(), stringObjectEntry.getValue()));
        logger.info("Number of guests {}", numberOfGuests.getPayload());

        return MessageBuilder.withPayload(true).build();
    }
}
