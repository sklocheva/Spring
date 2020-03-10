package com.boot.boats;

import com.boot.boats.controller.ShipwrecksController;
import com.boot.boats.model.Shipwreck;
import com.boot.boats.repository.ShipreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Sophia Klocheva
 * on 2/19/2020
 */
public class ShiprweckControllerTest
{
    @InjectMocks
    private ShipwrecksController shipwreck;

    @Mock
    private ShipreckRepository repository;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet()
    {
        //setup mock behavior
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        when(repository.findOne(1l)).thenReturn(sw);

        //test get method
        Shipwreck wreck = shipwreck.get(1L);

        //erifies certain behavior happened once.
        verify(repository).findOne(1l);

        assertEquals(1l, wreck.getId().longValue());
        //hamcrest matcher
        assertThat(wreck.getId(), is(1l));
    }
}
