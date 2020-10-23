package com.spring.demo.springintegrationswag.pattern.event.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Data
@AllArgsConstructor
public class Event
{
    private String id;
    private String type;
}
