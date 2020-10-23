package com.spring.demo.springintegrationswag.pattern.document.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Data
public class ReservationRecord
{
    private String name;
    private Date checkInDate;

    public ReservationRecord(String name, Date date)
    {
        this.name = name;
        this.checkInDate = date;
    }
}
