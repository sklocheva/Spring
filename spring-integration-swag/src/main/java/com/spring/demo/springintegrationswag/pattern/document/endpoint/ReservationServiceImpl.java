package com.spring.demo.springintegrationswag.pattern.document.endpoint;

import com.spring.demo.springintegrationswag.pattern.document.model.ReservationRecord;
import com.spring.demo.springintegrationswag.pattern.document.service.RegistrationRecordServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Service
@MessageEndpoint
public class ReservationServiceImpl implements ReservationService
{
    private static final Logger logger = LogManager.getLogger(ReservationServiceImpl.class);

    @ServiceActivator(inputChannel = "registrationRecordChannel")
    @Override
    public void addRecord(Message<ReservationRecord> recordMessage)
    {
        IntegrationMessageHeaderAccessor headerAccessor = new IntegrationMessageHeaderAccessor(recordMessage);
        logger.info("Sequence {}/{}", headerAccessor.getSequenceNumber(), headerAccessor.getSequenceSize());
        logger.info("Record payload {}", recordMessage.getPayload());
    }
}
