package com.pluralsight.demo.error;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

/**
 * @author Sophia Klocheva
 * on 10/21/2020
 */
@Component
public class RegistrationErrorHandler implements ErrorHandler
{
    @Override
    public void handleError(Throwable throwable)
    {
        throw new AmqpRejectAndDontRequeueException(throwable);
    }
}
