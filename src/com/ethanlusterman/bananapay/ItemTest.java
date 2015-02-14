package com.ethanlusterman.bananapay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {
    private Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item("A", 4.50);
        
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testSetBasePrice() throws Exception {
        assertThat(item.getBasePrice(), is(4.50));
        item.setBasePrice(5.50);
        assertThat(item.getBasePrice(), is(5.50));

    }

    @Test
    public void testSetVolumePrice() throws Exception {
        item.setVolumePrice(4, 16.00);
        assertThat(item.getVolumeCost(), is(16.00));
        assertThat(item.getVolumeQuantity(), is(4));
        assertThat(item.getTotalCost(4), is(16.00));
        assertThat(item.getTotalCost(8), is(32.00));
        assertThat(item.getTotalCost(6), is(25.00));

    }

    @Test
    public void testGetTotalCost() throws Exception {
        assertThat(item.getTotalCost(10), is(45.00));

    }

    @Test
    public void testGetName() throws Exception {
        assertThat(item.getName(), is("A"));

    }

    @Test
    public void testGetBasePrice() throws Exception {
        assertThat(item.getBasePrice(), is(4.50));

    }

    @Test
    public void testGetVolumeQuantity() throws Exception {
        assertThat(item.getVolumeQuantity(), is(Integer.MAX_VALUE));
        item.setVolumePrice(5, 20.00);
        assertThat(item.getVolumeQuantity(), is(5));

    }

    @Test
    public void testGetVolumeCost() throws Exception {
        assertThat(item.getVolumeCost(), is(0.0));
        item.setVolumePrice(5, 20.00);
        assertThat(item.getVolumeCost(), is(20.0));
        
    }
    
}