package com.clouway.builder;
import com.clouway.builder.order.Order;
import com.clouway.builder.order.OrderItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class BuilderTest {

    OrderBuilder orderBuilder;
    OrderItemBuilder itemBuilder;
    Order order;
    OrderItem item;
    List<OrderItem> items;

    @Before
    public void setUpOrder() {

        itemBuilder = new OrderItemBuilder();

        itemBuilder.setPrice(12.0);
        itemBuilder.setProductName("Lemon");
        item = itemBuilder.createOrderItem();

        items = new ArrayList<>();
        items.add(item);

        orderBuilder = new OrderBuilder();
        orderBuilder.setCustomerName("John");


        orderBuilder.setCustomerName("John");
        orderBuilder.setCustomerAddress("New York");
        orderBuilder.setItems(items);

    }


    @Test
    public void orderIsLate() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date creation = sdf.parse("21/12/2012");
        Date delivery = sdf.parse("22/12/2012");

        orderBuilder.setOrderCreationDate(creation);
        orderBuilder.setOrderDeliveryDate(delivery);

        order = orderBuilder.createOrder();

        assertThat(order.orderIsLate(), is(true));

    }

    @Test
    public void orderIsNotDeliveredYet() throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date creation = sdf.parse("21/12/2018");
        Date delivery = sdf.parse("22/12/2018");

        orderBuilder.setOrderCreationDate(creation);
        orderBuilder.setOrderDeliveryDate(delivery);

        order = orderBuilder.createOrder();

        assertThat(order.orderIsLate(), is(false));
    }

    @Test
    public void orderWasDelivered() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date creation = sdf.parse("15/05/2015");
        Date delivery = sdf.parse("22/12/2016");

        orderBuilder.setOrderCreationDate(creation);
        orderBuilder.setOrderDeliveryDate(delivery);

        order = orderBuilder.createOrder();
        order.deliver();

        assertThat(order.orderIsLate(), is(false));

    }

}
