package com.spring.demo.springintegrationswag.pattern.command.config;

import com.spring.demo.springintegrationswag.pattern.command.model.Swag;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@MessagingGateway(name = "swagGateway", defaultRequestChannel = "swagChannel")
public interface SwagGateway
{
    @Gateway
    void swagGateway(Message<Swag> swagMessage);
}
