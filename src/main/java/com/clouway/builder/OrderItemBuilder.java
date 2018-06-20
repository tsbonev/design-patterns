package com.clouway.builder;

import com.clouway.builder.order.OrderItem;

public class OrderItemBuilder {

    private String productName;
    private String measureUnit;
    private Double quantity;
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

        return new OrderItem(productName, measureUnit, quantity, price);
    }

}
