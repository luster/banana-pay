package com.ethanlusterman.bananapay;

/**
 * Created by ethan on 2/13/15.
 */
public class Item {
    
    private String name;
    private double basePrice;
    private Integer volumeQuantity;
    private double volumeCost;
    private String dealType; // Can be either "noDeal", "bulkRemainder", "bulkNoRemainder"
    
    public Item(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.volumeQuantity = Integer.MAX_VALUE;
        this.volumeCost = 0;
        this.dealType = "noDeal";
        
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

    public void setVolumePrice(Integer volumeQuantity, double volumeCost, String dealType) {
        
        if (!dealType.equals("bulkRemainder") && !dealType.equals("bulkNoRemainder")) {
            System.out.println("Deal type " + dealType + " does not exist!");
            return;
        }
        
        this.volumeQuantity = volumeQuantity;
        this.volumeCost = volumeCost;
        this.dealType = dealType;
        
    }
    
    public double getTotalCost(Integer quantity) {
        if (dealType.equals("bulkRemainder") || dealType.equals("noDeal"))
            return (volumeCost * (quantity / volumeQuantity) + basePrice * (quantity % volumeQuantity));
        else if (dealType.equals("bulkNoRemainder")) {
            if (quantity >= volumeQuantity)
                return volumeCost * quantity;
            else
                return basePrice * quantity;
        }
        else
            return basePrice * quantity;
        
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
