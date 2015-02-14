package com.ethanlusterman.bananapay;

import java.util.HashMap;

/**
 * Created by ethan on 2/13/15.
 */
public class Terminal {
    
    protected double total;
    private HashMap<String, Item> items;
    private HashMap<String, Integer> cart;
    
    public Terminal() {
        this.total = 0;
        this.items = new HashMap<String, Item>();
        this.cart = new HashMap<String, Integer>();

    }
    
    public void addItem(String itemName, double basePrice) {
        Item item = new Item(itemName, basePrice);
        items.put(itemName, item);

    }
    
    public void setBasePrice(String itemName, double basePrice) {
        Item item = items.get(itemName);
        if (item == null)
            return;

        item.setBasePrice(basePrice);
        items.put(itemName, item);
        
    }
    
    public void setDeal(String itemName, Integer volumeQuantity, double volumeCost) {
        Item item = items.get(itemName);
        if (item == null)
            return;
        
        item.setVolumePrice(volumeQuantity, volumeCost);
        items.put(itemName, item);
        
    }
    
    private void clearCart() {
        cart.clear();
        
    }
    
    public void scan(String itemName) {
        Item item = items.get(itemName);
        if (item == null) {
            System.out.println("Item " + itemName + " does not exist.");
            return;
            
        }
        
        Integer itemCount;
        if (!cart.containsKey(itemName)) {
            itemCount = 1;
            cart.put(itemName, itemCount);

        } else {
            itemCount = cart.get(itemName) + 1;
            cart.put(itemName, itemCount);
            
        }
        
        updateTotal(item, itemCount);
        printTotal();

    }
    
    private void updateTotal(Item item, Integer itemCount) {
        // Update total: subtract previous price from item, add current price from item
        total = total - item.getTotalCost(itemCount-1) + item.getTotalCost(itemCount);
        
    }
    
    public void printTotal() {
        System.out.println("Total: " + total);
        
    }
    
    public void voidItem(String itemName) {
        Item item = items.get(itemName);
        if (item == null) {
            System.out.println("Item " + itemName + " does not exist.");
            return;
            
        }
        
        Integer cartItemCount = cart.get(itemName);
        if (cartItemCount == null || cartItemCount == 0) {
            System.out.println("Item " + itemName + " is not currently in cart.");
            return;
        }
        
        cart.put(itemName, cartItemCount - 1);
        updateTotal(item, cartItemCount);
        
        printTotal();
    }
}
