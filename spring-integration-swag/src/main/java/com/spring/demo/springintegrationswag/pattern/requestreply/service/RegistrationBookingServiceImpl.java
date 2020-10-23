package com.spring.demo.springintegrationswag.pattern.requestreply.service;

import com.spring.demo.springintegrationswag.pattern.requestreply.config.HotelBookindGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Service
public class RegistrationBookingServiceImpl implements RegistrationBookingService
{
    private static final Logger logger = LogManager.getLogger(RegistrationBookingServiceImpl.class);

    @Autowired
    private HotelBookindGateway bookindGateway;

    @Override
    public Boolean checkAvailability(Integer numberOfGuests)
    {
        logger.info("Checking hotel availability for guests {}", numberOfGuests);
        Message<Integer> msg = MessageBuilder.withPayload(numberOfGuests).build();
        Message<Boolean> responseMessage = bookindGateway.checkAvailability(msg);

        logger.info("Availability response: {}", responseMessage);
        return responseMessage.getPayload();
    }
}
