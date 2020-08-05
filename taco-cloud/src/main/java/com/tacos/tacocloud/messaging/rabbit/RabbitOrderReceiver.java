package com.tacos.tacocloud.messaging.rabbit;

import com.tacos.tacocloud.model.Order;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 8/5/2020
 */
@Component
public class RabbitOrderReceiver
{
    private final RabbitTemplate rabbitTemplate;
    private final MessageConverter converter;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate)
    {
        this.rabbitTemplate = rabbitTemplate;
        this.converter = rabbitTemplate.getMessageConverter();
    }

    public Order receiveOrder()
    {
        Message message = rabbitTemplate.receive("tacocloud.orders");
        return message != null
                ? (Order) converter.fromMessage(message)
                : null;
    }

    public Order receiveAndConvertOrder()
    {
        return (Order) rabbitTemplate.receiveAndConvert("tacocloud.order.queue");
    }
}
