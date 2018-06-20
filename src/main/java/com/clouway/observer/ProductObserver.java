package com.clouway.observer;

public class ProductObserver implements Observer {

    @Override
    public void update(Product product, String message) {
        System.out.println(product.getQuantity() + " of " + product.getName().toLowerCase() +
        " at the price of " + product.getPrice() + " has been " + message);
    }
}
