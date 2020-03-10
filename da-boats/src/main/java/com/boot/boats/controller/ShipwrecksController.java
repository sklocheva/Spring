package com.boot.boats.controller;

import com.boot.boats.model.Shipwreck;
import com.boot.boats.repository.ShipreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sophia Klocheva
 * on 2/17/2020
 */
@RestController
@RequestMapping("api/v1")
public class ShipwrecksController
{

    @Autowired
    ShipreckRepository shipreckRepository;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list()
    {
        return shipreckRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck)
    {
        return shipreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable long id)
    {
        return shipreckRepository.findOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable long id, @RequestBody Shipwreck shipwreck)
    {
        Shipwreck existingShipwreck = shipreckRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck, existingShipwreck);
        return shipreckRepository.saveAndFlush(existingShipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck update(@PathVariable long id)
    {

        Shipwreck existingShipwreck = shipreckRepository.findOne(id);
        shipreckRepository.delete(existingShipwreck);
        return existingShipwreck;
    }


}
