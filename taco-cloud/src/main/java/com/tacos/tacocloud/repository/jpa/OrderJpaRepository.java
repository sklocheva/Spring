package com.tacos.tacocloud.repository.jpa;

import com.tacos.tacocloud.model.Order;
import com.tacos.tacocloud.model.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Sophia Klocheva
 * on 7/20/2020
 */
public interface OrderJpaRepository extends CrudRepository<Order, Long>
{
    // Spring attempts to understand the
    // method’s purpose in the context of the persisted object
    List<Order> findByZip(String deliveryZip);

    List<Order> readOrdersByZipAndPlacedAtBetween(
            String Zip, Date startDate, Date endDate);

    List<Order> findByCityOrderByZip(String city);

    List<Order> findByUserOrderByPlacedAtDesc(Users user, Pageable pageable);

//    @Query("Order o where o.deliveryCity='Seattle'")
//    List<Order> readOrdersDeliveredInSeattle();
}
