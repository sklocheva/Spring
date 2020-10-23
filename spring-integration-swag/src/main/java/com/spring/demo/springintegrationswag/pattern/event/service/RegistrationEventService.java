package com.spring.demo.springintegrationswag.pattern.event.service;

import com.spring.demo.springintegrationswag.pattern.event.model.Event;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
public interface RegistrationEventService
{
    void notifyObservers(Event event);
}
