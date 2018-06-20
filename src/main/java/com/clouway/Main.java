package com.clouway;

import com.clouway.builder.OrderBuilder;
import com.clouway.builder.OrderItemBuilder;
import com.clouway.builder.order.Order;
import com.clouway.builder.order.OrderItem;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        OrderBuilder orderBuilder = new OrderBuilder();

        OrderItemBuilder itemBuilder = new OrderItemBuilder();

        itemBuilder.setProductName("Lemon");
        itemBuilder.setQuantity(1.0D);
        itemBuilder.setMeasureUnit("kilograms");
        itemBuilder.setPrice(0.5D);
        OrderItem item = itemBuilder.createOrderItem();

        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(item);

        orderBuilder.setOrderId(1L);
        orderBuilder.setCustomerName("John");
        orderBuilder.setCustomerAddress("New York");
        orderBuilder.setOrderCreationDate(Date.from(Instant.now()));
        orderBuilder.setOrderDeliveryDate(Date.from(Instant.now()));
        orderBuilder.setItems(orderItemList);

        Order order = orderBuilder.createOrder();

        System.out.println(order.getItems()
                .stream()
                .anyMatch(i -> i.getProductName().equalsIgnoreCase("lemon")));


    }
}
