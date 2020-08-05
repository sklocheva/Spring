package com.tacos.tacocloud.rest;

import com.tacos.tacocloud.repository.jpa.OrderJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sophia Klocheva
 * on 7/29/2020
 */
@RestController
@RequestMapping(path = "api/orders", produces = "application/json")
public class OrderAPIController
{
    private final OrderJpaRepository jpaRepository;

    public OrderAPIController(OrderJpaRepository jpaRepository)
    {
        this.jpaRepository = jpaRepository;
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId)
    {
        jpaRepository.deleteById(orderId);
    }

}
