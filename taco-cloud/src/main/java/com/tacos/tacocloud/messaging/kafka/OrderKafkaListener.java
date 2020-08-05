package com.tacos.tacocloud.messaging.kafka;

import com.tacos.tacocloud.KitchenUI;
import com.tacos.tacocloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 8/5/2020
 * <p>
 * Kafka does not have on demand receiver.
 */
@Component
@Slf4j
public class OrderKafkaListener
{
    private final KitchenUI kitchenUI;

    @Autowired
    public OrderKafkaListener(KitchenUI kitchenUI)
    {
        this.kitchenUI = kitchenUI;
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handleMessage(Order order)
    {
        kitchenUI.displayOrder(order);
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handleMessage(Order order, ConsumerRecord<String, Order> record)
    {
        log.info("Received from partition {} with timestamp {}",
                record.partition(), record.timestamp());
        kitchenUI.displayOrder(order);
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handleMessage(Order order, Message<Order> message)
    {
        MessageHeaders headers = message.getHeaders();
        log.info("Received from partition {} with timestamp {}",
                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID),
                headers.get(KafkaHeaders.RECEIVED_TIMESTAMP));
        kitchenUI.displayOrder(order);
    }
}
