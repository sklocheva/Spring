package com.spring.demo.springintegrationswag.pattern.command.endpoint;

import com.spring.demo.springintegrationswag.pattern.command.model.Swag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@MessageEndpoint
@Service
public class SwagServiceImpl implements SwagService
{

    private static final Logger logger = LogManager.getLogger(SwagServiceImpl.class);

    @ServiceActivator(inputChannel = "swagChannel")
    public void sendSwag(Message<Swag> msg)
    {
        logger.info("Swag Service sending swag {}", msg.getHeaders());
    }
}
