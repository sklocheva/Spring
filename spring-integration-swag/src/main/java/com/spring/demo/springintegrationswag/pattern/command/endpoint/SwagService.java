package com.spring.demo.springintegrationswag.pattern.command.endpoint;

import com.spring.demo.springintegrationswag.pattern.command.model.Swag;
import org.springframework.messaging.Message;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
public interface SwagService
{
    void sendSwag(Message<Swag> msg);
}
