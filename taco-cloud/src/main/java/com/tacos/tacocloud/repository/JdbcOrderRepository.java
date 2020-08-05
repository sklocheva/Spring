package com.tacos.tacocloud.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tacos.tacocloud.model.Order;
import com.tacos.tacocloud.model.Taco;
import com.tacos.tacocloud.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sophia Klocheva
 * on 7/17/2020
 */
@Repository
@Slf4j
public class JdbcOrderRepository implements OrderRepository
{
    private SimpleJdbcInsert orderInsert;
    private SimpleJdbcInsert orderTacoInsert;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbcTemplate)
    {
        // provided id prop
        this.orderInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");
        this.orderTacoInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Taco_Order_Tacos");
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Order saveOrder(Order order)
    {
        order.setPlacedAt(new Date());
        log.info(order.toString());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Taco> tacos = order.getTacos();
        for (Taco taco : tacos)
        {
            saveTacoToOrder(taco, orderId);
        }

        return order;
    }

    private void saveTacoToOrder(Taco taco, long orderId)
    {
        Map<String, Object> val = new HashMap<>();
        val.put("tacoOrder", orderId);
        val.put("taco", taco.getId());
        orderTacoInsert.execute(val);
    }

    private long saveOrderDetails(Order order)
    {
        Map<String, Object> objectMap = objectMapper.convertValue(order, Map.class);
        // ?
//        log.info(objectMap.get(order).toString());
//        log.info(objectMap.toString());
        objectMap.put("placedAt", order.getPlacedAt());
        return orderInsert.executeAndReturnKey(objectMap).longValue();
    }
}
