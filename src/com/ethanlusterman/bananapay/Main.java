package com.ethanlusterman.bananapay;

public class Main {

    public static void main(String[] args) {
        Item x = new Item("A");
        x.setBasePrice(4.50);
        x.setVolumePrice(4,15);
        System.out.println(x.getTotalCost(5));
        System.out.println(x.getTotalCost(6));
        System.out.println(x.getTotalCost(10));
        System.out.println(x.getTotalCost(4));
        
        Item y = new Item("B");
        y.setBasePrice(4.50);
        System.out.println(y.getTotalCost(5));
        System.out.println(y.getTotalCost(6));
        System.out.println(y.getTotalCost(10));
        System.out.println(y.getTotalCost(4));
        
        System.out.println(System.getProperty("user.dir"));
    }
}
