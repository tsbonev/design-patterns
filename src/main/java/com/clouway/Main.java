package com.clouway;

import com.clouway.observer.Product;
import com.clouway.observer.Storage;

public class Main {

    public static void main(String[] args) {

        Product milk = new Product("Milk", 2, 2.0D);
        Product bread = new Product("Bread", 4, 1.0D);
        Product chocolate = new Product("Chocolate", 5, 4.0D);
        Product shoe = new Product("Shoe", 12, 55.55D);

        Storage storage = new Storage();

        storage.addProduct(milk);
        storage.addProduct(bread);
        storage.addProduct(chocolate);

        storage.sellProduct(milk);
        storage.sellProduct(shoe);

        storage.printStatistics();

    }
}
