package com.clouway.builder;

import com.clouway.builder.order.Order;
import com.clouway.builder.order.OrderItem;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderBuilder {

    private Long orderId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    private String customerName;
    private String customerAddress;
    private Date orderCreationDate = Date.from(Instant.now());
    private Date orderDeliveryDate;
    private List<OrderItem> items;

    public OrderBuilder(){}

    public OrderBuilder setOrderId(Long Id){
        this.orderId = Id;
        return this;
    }

    public OrderBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public OrderBuilder setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public OrderBuilder setOrderCreationDate(Date orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
        return this;
    }

    public OrderBuilder setOrderDeliveryDate(Date orderDeliveryDate) {
        this.orderDeliveryDate = orderDeliveryDate;
        return this;
    }

    public OrderBuilder setItems(List<OrderItem> items) {
        this.items = items;
        return this;
    }

    public Order createOrder(){

        if(customerName == null
                || customerAddress == null
                || orderDeliveryDate == null
                || items == null) throw new IllegalStateException();

        if(orderDeliveryDate.before(orderCreationDate)) throw new IllegalStateException();

        return new Order(orderId, customerName, customerAddress, orderCreationDate, orderDeliveryDate, items);
    }
}
