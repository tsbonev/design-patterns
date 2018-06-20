package com.clouway.observer;

import java.util.ArrayList;
import java.util.List;

public class Storage extends Statistics {

    private List<Product> stock;
    private Sold sold;
    private Observer stockObserver;
    private Observer soldObserver;

    public Storage() {
        this.stock = new ArrayList<>();
        this.sold = new Sold();
        this.stockObserver = new ProductObserver();
        this.soldObserver = new ProductObserver();
    }

    public void addProduct(Product product){

        stock.add(product);
        stockObserver.update(product, "added");

    }

    public void sellProduct(Product product){

        if(stock.contains(product)){
            stock.remove(product);
            sold.addSoldProduct(product);
            soldObserver.update(product, "sold");
        }
        else {
            System.out.println("There is no " + product.getName().toLowerCase() + " in storage");
        }

    }

    public void printStatistics(){

        super.printStatistics(this.stock, "Products in storage:");
        sold.printStatistics();

    }


}
