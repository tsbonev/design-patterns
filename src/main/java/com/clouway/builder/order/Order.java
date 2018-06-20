package com.clouway.builder.order;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public final class Order {

    private Long orderId;
    private String customerName;
    private String customerAddress;
    private Date orderCreationDate;
    private Date orderDeliveryDate;
    private List<OrderItem> items;

    private boolean isDelivered = false;

    public boolean isDelivered() {
        return isDelivered;
    }

    public void deliver(){
        this.isDelivered = true;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Date getOrderCreationDate() {
        return orderCreationDate;
    }

    public Date getOrderDeliveryDate() {
        return orderDeliveryDate;
    }

    public boolean orderIsLate(){

        if(this.orderDeliveryDate.before(Date.from(Instant.now()))
                && !isDelivered) return true;
        else return false;

    }

    public List<OrderItem> getItems() {
        return items;
    }

    public static class Builder{

        private Long orderId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        private String customerName;
        private String customerAddress;
        private Date orderCreationDate = Date.from(Instant.now());
        private Date orderDeliveryDate;
        private List<OrderItem> items;

        public Builder(){}

        public Builder setOrderId(Long Id){
            this.orderId = Id;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }

        public Builder setOrderCreationDate(Date orderCreationDate) {
            this.orderCreationDate = orderCreationDate;
            return this;
        }

        public Builder setOrderDeliveryDate(Date orderDeliveryDate) {
            this.orderDeliveryDate = orderDeliveryDate;
            return this;
        }

        public Builder setItems(List<OrderItem> items) {
            this.items = items;
            return this;
        }

        public Order build(){

            if(customerName == null
                    || customerAddress == null
                    || orderDeliveryDate == null
                    || items == null) throw new IllegalStateException();

            if(orderDeliveryDate.before(orderCreationDate)) throw new IllegalStateException();

            return new Order(orderId, customerName, customerAddress, orderCreationDate, orderDeliveryDate, items);
        }


    }

    private Order(Long orderId, String customerName, String customerAddress, Date orderCreationDate, Date orderDeliveryDate, List<OrderItem> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderCreationDate = orderCreationDate;
        this.orderDeliveryDate = orderDeliveryDate;
        this.items = items;
    }
}
