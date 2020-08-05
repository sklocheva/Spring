package com.tacos.tacocloud.controller;

import com.tacos.tacocloud.configuration.OrderProps;
import com.tacos.tacocloud.model.Order;
import com.tacos.tacocloud.model.Users;
import com.tacos.tacocloud.repository.OrderRepository;
import com.tacos.tacocloud.repository.jpa.OrderJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * @author Sophia Klocheva
 * on 7/14/2020
 */
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("order")
@Controller
public class OrderController
{
    private final OrderProps orderProps;
    private OrderRepository orderRepository;
    private final OrderJpaRepository orderJPARepository;


    @Autowired
    public OrderController(OrderRepository orderRepository, OrderProps orderProps, OrderJpaRepository orderJPARepository)
    {
        this.orderRepository = orderRepository;
        this.orderProps = orderProps;
        this.orderJPARepository = orderJPARepository;
    }

    /**
     * Visualizes order form for current order
     *
     * @param model
     * @return
     */
    @GetMapping("/current")
    public String orderForm(Model model)
    {
//        model.addAttribute("order", new Order());
        return "orderForm";
    }

    /**
     * Shows all orders by user
     *
     * @param user
     * @param model
     * @return
     */
    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal Users user, Model model)
    {
        Pageable pageable = PageRequest.of(0, orderProps.getPageSize());
        model.addAttribute("orders",
                orderJPARepository.findByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";
    }

    /*   There are several ways to determine who the user is. These are a few of the most
        common ways:
         Inject a Principal object into the controller method
         Inject an Authentication object into the controller method
         Use SecurityContextHolder to get at the security context
         Use an @AuthenticationPrincipal annotated method
     */

    /**
     * Processes order information in DB
     *
     * @param order
     * @param errors
     * @param status
     * @param users
     * @return
     */
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus status,
                               @AuthenticationPrincipal Users users)
    {
        if (errors.hasErrors())
        {
            log.warn(errors.getAllErrors().toString());
            return "orderForm";
        }
        order.setUser(users);
        log.info("Saving order: " + order);
        orderRepository.saveOrder(order);
        //cleanup session attr
        status.setComplete();
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
