package com.tacos.tacocloud.messaging.jms;

import com.tacos.tacocloud.model.Order;

import javax.jms.JMSException;

/**
 * @author Sophia Klocheva
 * on 7/31/2020
 */
public interface OrderReceiver
{
    Order receiveOrder() throws JMSException;
    Order receiveAndConvertOrder();
}
