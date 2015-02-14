package com.ethanlusterman.bananapay;

/**
 * Created by ethan on 2/13/15.
 */
public class Item {
    
    private String name;
    private double basePrice;
    private Integer volumeQuantity;
    private double volumeCost;
    
    public Item(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.volumeQuantity = Integer.MAX_VALUE;
        this.volumeCost = 0;
        
    }

    public Item(String name, double basePrice, Integer volumeQuantity, double volumeCost) {
        this.name = name;
        this.basePrice = basePrice;
        this.volumeQuantity = volumeQuantity;
        this.volumeCost = volumeCost;

    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
        
    }

    public void setVolumePrice(Integer volumeQuantity, double volumeCost) {
        this.volumeQuantity = volumeQuantity;
        this.volumeCost = volumeCost;
        
    }
    
    public double getTotalCost(Integer quantity) {
        return (volumeCost * (quantity / volumeQuantity) + basePrice * (quantity % volumeQuantity));
        
    }
    
    public String getName() {
        return name;
        
    }

    public double getBasePrice() {
        return basePrice;
        
    }

    public Integer getVolumeQuantity() {
        return volumeQuantity;
        
    }

    public double getVolumeCost() {
        return volumeCost;
        
    }
}
