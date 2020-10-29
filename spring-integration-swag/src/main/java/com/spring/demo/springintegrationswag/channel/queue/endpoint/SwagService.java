package com.spring.demo.springintegrationswag.channel.queue.endpoint;

import com.spring.demo.springintegrationswag.pattern.command.model.Swag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 10/23/2020
 */
@Service
@Slf4j
public class SwagService
{
    @ServiceActivator(inputChannel = "queueChannel", poller = @Poller(fixedDelay = "100"))
    public void receiveSwag(Message<Swag> swagMessage)
    {
        log.info("Received swag message {}", swagMessage.getPayload());
        try
        {
            //Imitate queueing behavior
            Thread.sleep(1000);
        }
        catch (Exception ignored)
        {
        }

    }
}
