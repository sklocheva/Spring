package com.spring.demo.springintegrationswag.pattern.document.config;

import com.spring.demo.springintegrationswag.pattern.document.model.ReservationRecord;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@MessagingGateway(name = "registrationRecordGateway", defaultRequestChannel = "registrationRecordChannel")
public interface ReservationRecordGateway
{
    @Gateway
    void addRecord(Message<ReservationRecord> record);
}
