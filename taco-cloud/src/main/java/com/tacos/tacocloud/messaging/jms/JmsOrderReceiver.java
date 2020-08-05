package com.tacos.tacocloud.messaging.jms;

import com.tacos.tacocloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * @author Sophia Klocheva
 * on 7/31/2020
 * <p>
 * Explicit receiver on demand.
 */
@Component
public class JmsOrderReceiver implements OrderReceiver
{
    private final JmsTemplate jmsTemplate;
    private final MessageConverter messageConverter;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jmsTemplate)
    {
        this.jmsTemplate = jmsTemplate;
        this.messageConverter = jmsTemplate.getMessageConverter();
    }

    @Override
    public Order receiveOrder() throws JMSException
    {
        Message message = jmsTemplate.receive("tacocloud.order.queue");
        return (Order) messageConverter.fromMessage(message);
    }

    public Order receiveAndConvertOrder()
    {
        return (Order) jmsTemplate.receiveAndConvert("tacocloud.order.queue");
    }
}
