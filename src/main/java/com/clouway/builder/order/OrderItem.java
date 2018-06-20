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

    public static class Builder{

        private String productName;
        private String measureUnit = "kilograms";
        private Double quantity = 1.0;
        private Double price;

        public Builder setProductName(String productName){
            this.productName = productName;
            return this;
        }

        public Builder setMeasureUnit(String measureUnit){
            this.measureUnit = measureUnit;
            return this;
        }

        public Builder setQuantity(Double quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(Double price){
            this.price = price;
            return this;
        }

        public OrderItem build(){

            if(price == null || productName == null) throw new IllegalStateException();

            return new OrderItem(productName, measureUnit, quantity, price);
        }

    }

    private OrderItem(String productName, String measureUnit, Double quantity, Double price) {
        this.productName = productName;
        this.measureUnit = measureUnit;
        this.quantity = quantity;
        this.price = price;
    }
}
