package com.spring.demo.springintegrationswag.channel.queue.config;

import com.spring.demo.springintegrationswag.pattern.command.model.Swag;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

/**
 * @author Sophia Klocheva
 * on 10/23/2020
 */
@MessagingGateway(name = "queueChannelGateway", defaultRequestChannel = "queueChannel")
public interface QueueChannelGateway
{
    @Gateway
    void sendSwag(Message<Swag> swagMessage);
}
