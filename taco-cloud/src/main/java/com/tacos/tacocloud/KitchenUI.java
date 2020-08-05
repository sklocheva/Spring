package com.tacos.tacocloud;

import com.tacos.tacocloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 8/5/2020
 */
@Component
@Slf4j
public class KitchenUI {

    public void displayOrder(Order order) {
        // TODO: Beef this up to do more than just log the received taco.
        //       To display it in some sort of UI.
        log.info("RECEIVED ORDER:  " + order);
    }

}

