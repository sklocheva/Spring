package com.spring.demo.springintegrationswag.channel.queue.service;

import com.spring.demo.springintegrationswag.channel.queue.config.QueueChannelGateway;
import com.spring.demo.springintegrationswag.pattern.command.model.Swag;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 10/23/2020
 */
@Service
@Slf4j
public class RegistrationService
{
    @Autowired
    private QueueChannelGateway queueChannelGateway;

    public void commit(String userId)
    {
        queueChannelGateway.sendSwag(MessageBuilder.withPayload(new Swag("T-Shirt")).build());
        queueChannelGateway.sendSwag(MessageBuilder.withPayload(new Swag("Hat")).build());
        queueChannelGateway.sendSwag(MessageBuilder.withPayload(new Swag("Keychain")).build());
        queueChannelGateway.sendSwag(MessageBuilder.withPayload(new Swag("Mug")).build());

        log.info("Finished sending swag messages");
    }
}
