package com.ethanlusterman.bananapay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TerminalTest {
    private Terminal t;

    @Before
    public void setUp() throws Exception {
        t = new Terminal();
    }

    @After
    public void tearDown() throws Exception {
        t.clearCart();

    }

    @Test
    public void testAddItem() throws Exception {

    }

    @Test
    public void testSetBasePrice() throws Exception {

    }

    @Test
    public void testSetDeal() throws Exception {

    }

    @Test
    public void testScan() throws Exception {

    }

    @Test
    public void testVoidItem() throws Exception {

    }

    @Test
    public void testClearCart() throws Exception {

    }

    @Test
    public void testPrintTotal() throws Exception {

    }
}