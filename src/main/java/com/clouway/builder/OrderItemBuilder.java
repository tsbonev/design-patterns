package com.clouway.builder;

import com.clouway.builder.order.OrderItem;

public class OrderItemBuilder {

    private String productName;
    private String measureUnit = "kilograms";
    private Double quantity = 1.0;
    private Double price;

    public OrderItemBuilder setProductName(String productName){
        this.productName = productName;
        return this;
    }

    public OrderItemBuilder setMeasureUnit(String measureUnit){
        this.measureUnit = measureUnit;
        return this;
    }

    public OrderItemBuilder setQuantity(Double quantity){
        this.quantity = quantity;
        return this;
    }

    public OrderItemBuilder setPrice(Double price){
        this.price = price;
        return this;
    }

    public OrderItem createOrderItem(){

        if(price == null || productName == null) throw new IllegalArgumentException();

        return new OrderItem(productName, measureUnit, quantity, price);
    }

}
