package com.ethanlusterman.bananapay;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Terminal terminal = new Terminal();
        String file = "./data/items.csv";
        loadItemData(terminal, file);

    }
    
    public static void loadItemData(Terminal terminal, String file) {
        // Product Code,Price,Volume Quantity,Volume Price;
        BufferedReader br = null;
        String line = "";
        String delimiter = ",";
        
        String itemName;
        double basePrice;
        Integer volumeQuantity;
        double volumeCost;
        
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] item = line.split(delimiter);
                if (item.length < 2)
                    continue;

                itemName = item[0];
                try {
                    basePrice = Double.parseDouble(item[1]);
                } catch (NumberFormatException e) {
                    continue;
                }
                terminal.addItem(itemName, basePrice);

                if (item.length == 4) {
                    try {
                        volumeQuantity = Integer.parseInt(item[2]);
                        volumeCost = Double.parseDouble(item[3]);
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    terminal.setDeal(itemName, volumeQuantity, volumeCost);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
