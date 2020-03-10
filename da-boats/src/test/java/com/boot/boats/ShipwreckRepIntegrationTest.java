package com.boot.boats;

import com.boot.boats.model.Shipwreck;
import com.boot.boats.repository.ShipreckRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

/**
 * @author Sophia Klocheva
 * on 2/19/2020
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DaBoats.class)
//using the context of the application without spring boot
//@ContextConfiguration(classes = DaBoats.class)
public class ShipwreckRepIntegrationTest
{
    @Autowired
    private ShipreckRepository shipwreckRepository;

    @Test
    public void testFindAll() {
        List<Shipwreck> wrecks = shipwreckRepository.findAll();
        assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
    }
}
