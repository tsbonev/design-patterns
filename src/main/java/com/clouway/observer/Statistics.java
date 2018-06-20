package com.clouway.observer;

import java.util.List;

public abstract class Statistics {

    public void printStatistics(List<Product> list, String message){

        System.out.println(message);

        for (Product product : list) {
            System.out.println("Name: " + product.getName().toLowerCase());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
            System.out.println();
        }

    }

}
