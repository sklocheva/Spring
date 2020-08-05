package com.tacos.tacocloud.messaging.kafka;

import com.tacos.tacocloud.messaging.OrderMessagingService;
import com.tacos.tacocloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 8/5/2020
 */
@Component
public class KafkaOrderMessagingService implements OrderMessagingService
{
    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    public KafkaOrderMessagingService(KafkaTemplate<String, Order> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder(Order order)
    {
        //send to a toppic
        kafkaTemplate.send("tacocloud.orders.topic", order);
        //send to default topic from prop
        kafkaTemplate.sendDefault(order);
    }
}
