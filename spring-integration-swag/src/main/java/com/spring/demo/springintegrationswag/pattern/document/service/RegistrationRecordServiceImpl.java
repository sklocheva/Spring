package com.spring.demo.springintegrationswag.pattern.document.service;

import com.spring.demo.springintegrationswag.pattern.document.config.ReservationRecordGateway;
import com.spring.demo.springintegrationswag.pattern.document.model.ReservationRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Service
public class RegistrationRecordServiceImpl implements RegistrationRecordService
{
    private static final Logger logger = LogManager.getLogger(RegistrationRecordServiceImpl.class);

    @Autowired
    private ReservationRecordGateway recordGateway;

    @Override
    public void updateReservationRecord(ReservationRecord record)
    {
        logger.info("Adding registration to record: {}", record);

        Message<ReservationRecord> msg = MessageBuilder.withPayload(record)
                .setHeader(IntegrationMessageHeaderAccessor.SEQUENCE_NUMBER, 1)
                .setHeader(IntegrationMessageHeaderAccessor.SEQUENCE_SIZE, 5)
                .build();
        recordGateway.addRecord(msg);

    }
}
