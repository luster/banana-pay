package com.ethanlusterman.bananapay;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        
        Terminal terminal = new Terminal();
        terminal.addItem("A", 4.50);
        terminal.setDeal("A", 4, 15.00);
        terminal.addItem("B", 10.00);
        terminal.scan("A");
        terminal.scan("A");
        terminal.scan("A");
        terminal.scan("A");
        terminal.scan("A");

        // Product Code,Price,Volume Quantity,Volume Price
        String file = "./data/items.csv";
        BufferedReader br = null;
        String line = "";
        String delimiter = ",";
        
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] item = line.split(delimiter);
                if (item.length == 2)
                    ;

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
