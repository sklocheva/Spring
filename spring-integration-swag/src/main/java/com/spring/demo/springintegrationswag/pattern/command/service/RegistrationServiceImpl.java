package com.spring.demo.springintegrationswag.pattern.command.service;

import com.spring.demo.springintegrationswag.pattern.command.config.SwagGateway;
import com.spring.demo.springintegrationswag.pattern.command.model.Swag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Service
public class RegistrationServiceImpl implements RegistrationService
{
    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private SwagGateway swagGateway;

    public void commit(String userId)
    {
        logger.info("Registration commited, sending swag message");
        Message<Swag> msg = MessageBuilder.withPayload(new Swag("T-Shirt")).build();
        swagGateway.swagGateway(msg);
    }
}
