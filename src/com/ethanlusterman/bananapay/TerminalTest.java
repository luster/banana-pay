package com.ethanlusterman.bananapay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TerminalTest {
    private Terminal terminal;

    @Before
    public void setUp() throws Exception {
        terminal = new Terminal();
        Main.loadItemData(terminal, "./data/items.csv");
    }

    @After
    public void tearDown() throws Exception {
        terminal.clearItems();

    }
    
    @Test
    public void testTotal1() throws Exception {
        terminal.scan("A");
        terminal.scan("B");
        terminal.scan("C");
        terminal.scan("D");
        terminal.scan("A");
        terminal.scan("B");
        terminal.scan("A");
        terminal.scan("A");
        assertThat(terminal.total, is(32.40));
        
    }


    @Test
    public void testTotal2() throws Exception {
        terminal.scan("C", 7);
        assertThat(terminal.total, is(7.25));

    }

    @Test
    public void testTotal3() throws Exception {
        terminal.scan("A");
        terminal.scan("B");
        terminal.scan("C");
        terminal.scan("D");
        assertThat(terminal.total, is(15.40));

    }

    @Test
    public void testAddItem() throws Exception {
        terminal.addItem("A", 7.40);
        assertThat(terminal.getItem("A").getName(), is("A"));
        assertThat(terminal.getItem("A").getBasePrice(), is(7.40));

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