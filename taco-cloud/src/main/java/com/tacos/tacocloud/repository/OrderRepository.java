package com.tacos.tacocloud.repository;

import com.tacos.tacocloud.model.Order;
import com.tacos.tacocloud.model.Users;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Sophia Klocheva
 * on 7/16/2020
 */
public interface OrderRepository
{
    Order saveOrder(Order order);
}
