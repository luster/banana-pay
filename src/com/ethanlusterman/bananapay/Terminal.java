package com.ethanlusterman.bananapay;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ethan on 2/13/15.
 */
public class Terminal {
    private double total;
    private HashMap<Item, Integer> items;
    
    public Terminal() {
        this.total = 0;
        this.items = new HashMap<Item, Integer>();

    }
    
    public void setPricing() {}
}
