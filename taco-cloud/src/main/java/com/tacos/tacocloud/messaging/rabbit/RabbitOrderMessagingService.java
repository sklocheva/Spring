package com.tacos.tacocloud.messaging.rabbit;

import com.tacos.tacocloud.messaging.OrderMessagingService;
import com.tacos.tacocloud.model.Order;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 8/5/2020
 */
@Component
public class RabbitOrderMessagingService implements OrderMessagingService
{
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitOrderMessagingService(RabbitTemplate rabbitTemplate)
    {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendOrder(Order order)
    {
        MessageConverter converter = rabbitTemplate.getMessageConverter();
        //default instance
        MessageProperties properties = new MessageProperties();
        Message message = converter.toMessage(order, properties);
        rabbitTemplate.send(
                "tacocloud.order", message);

        //convert and send
        rabbitTemplate.convertAndSend("tacocloud.order", order);
    }
}
