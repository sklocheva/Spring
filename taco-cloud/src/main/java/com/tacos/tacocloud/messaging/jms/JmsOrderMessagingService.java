package com.tacos.tacocloud.messaging.jms;

import com.tacos.tacocloud.messaging.OrderMessagingService;
import com.tacos.tacocloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @author Sophia Klocheva
 * on 7/31/2020
 */
@Service
public class JmsOrderMessagingService implements OrderMessagingService
{
    private final JmsTemplate jmsTemplate;
    private final Destination destination;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jmsTemplate, Destination destination)
    {
        this.jmsTemplate = jmsTemplate;
        this.destination = destination;
    }

    @Override
    public void sendOrder(Order order)
    {
        // destination specified in properties
        jmsTemplate.send(session -> session.createObjectMessage(order));
        //specific destination form a bean
        jmsTemplate.send(destination, session -> session.createObjectMessage(order));
        //destination from a name
        jmsTemplate.send("tacocloud.order.queue3", session -> session.createObjectMessage(order));

        //convert and send
        jmsTemplate.convertAndSend(destination, order);
    }
}
