package com.clouway.observer;

import java.util.ArrayList;
import java.util.List;

public class Sold extends Statistics {

    private List<Product> sold;

    public Sold() {
        this.sold = new ArrayList<>();
    }

    public void addSoldProduct(Product product){
        this.sold.add(product);
    }

    public void printStatistics(){
        super.printStatistics(this.sold, "Products sold:");
    }

}
