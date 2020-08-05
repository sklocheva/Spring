package com.tacos.tacocloud.messaging;

import com.tacos.tacocloud.model.Order;

/**
 * @author Sophia Klocheva
 * on 7/31/2020
 *
 */
public interface OrderMessagingService
{
    void sendOrder(Order order);
}
