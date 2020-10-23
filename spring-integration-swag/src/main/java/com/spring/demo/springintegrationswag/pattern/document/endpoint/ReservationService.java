package com.spring.demo.springintegrationswag.pattern.document.endpoint;

import com.spring.demo.springintegrationswag.pattern.document.model.ReservationRecord;
import org.springframework.messaging.Message;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
public interface ReservationService
{

    void addRecord(Message<ReservationRecord> recordMessage);
}
