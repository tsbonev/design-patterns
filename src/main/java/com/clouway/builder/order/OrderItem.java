package com.clouway.builder.order;

public final class OrderItem {

    private String productName;
    private String measureUnit;
    private Double quantity;
    private Double price;

    public String getProductName() {
        return productName;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public OrderItem(String productName, String measureUnit, Double quantity, Double price) {
        this.productName = productName;
        this.measureUnit = measureUnit;
        this.quantity = quantity;
        this.price = price;
    }
}
