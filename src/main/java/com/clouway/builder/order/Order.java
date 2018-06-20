package com.clouway.builder.order;

import java.util.Date;
import java.util.List;

public final class Order {

    private Long orderId;
    private String customerName;
    private String customerAddress;
    private Date orderCreationDate;
    private Date orderDeliveryDate;
    private List<OrderItem> items;

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

    public List<OrderItem> getItems() {
        return items;
    }

    public Order(Long orderId, String customerName, String customerAddress, Date orderCreationDate, Date orderDeliveryDate, List<OrderItem> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderCreationDate = orderCreationDate;
        this.orderDeliveryDate = orderDeliveryDate;
        this.items = items;
    }
}
