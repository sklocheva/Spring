package com.tacos.tacocloud.messaging.rabbit.listener;

import com.tacos.tacocloud.KitchenUI;
import com.tacos.tacocloud.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 8/5/2020
 */
@Component
public class OrderRabbitListener
{
    private final KitchenUI kitchenUI;

    @Autowired
    public OrderRabbitListener(KitchenUI kitchenUI)
    {
        this.kitchenUI = kitchenUI;
    }

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(Order order)
    {
        kitchenUI.displayOrder(order);
    }
}
