package com.tacos.tacocloud.messaging.jms.listener;

import com.tacos.tacocloud.KitchenUI;
import com.tacos.tacocloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 8/5/2020
 * <p>
 * Message listener that reacts to JMS messages.
 */
@Component
public class OrderListener
{
    private final KitchenUI ui;

    @Autowired
    public OrderListener(KitchenUI ui)
    {
        this.ui = ui;
    }

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order)
    {
        ui.displayOrder(order);
    }
}
