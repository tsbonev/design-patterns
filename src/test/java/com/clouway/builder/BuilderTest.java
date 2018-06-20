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

    Order order;
    OrderItem item;
    List<OrderItem> items;

    @Before
    public void setUpItems(){

        items = new ArrayList<>();
        item = new OrderItem.Builder().setPrice(1.0)
                .setProductName("Lemon").build();
        items.add(item);

    }

    @Test
    public void orderIsLate() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date creation = sdf.parse("21/12/2012");
        Date delivery = sdf.parse("22/12/2012");

        order = new Order.Builder().setOrderCreationDate(creation)
                .setOrderDeliveryDate(delivery)
                .setItems(items)
                .setCustomerAddress("New York")
                .setCustomerName("John")
                .build();

        assertThat(order.orderIsLate(), is(true));

    }

    @Test
    public void orderIsNotDeliveredYet() throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date creation = sdf.parse("21/12/2018");
        Date delivery = sdf.parse("22/12/2018");

        order = new Order.Builder().setOrderCreationDate(creation)
                .setOrderDeliveryDate(delivery)
                .setItems(items)
                .setCustomerAddress("New York")
                .setCustomerName("John")
                .build();

        assertThat(order.orderIsLate(), is(false));
    }

    @Test
    public void orderWasDelivered() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date creation = sdf.parse("15/05/2015");
        Date delivery = sdf.parse("22/12/2016");

        order = new Order.Builder().setOrderCreationDate(creation)
                .setOrderDeliveryDate(delivery)
                .setItems(items)
                .setCustomerAddress("New York")
                .setCustomerName("John")
                .build();
        order.deliver();

        assertThat(order.orderIsLate(), is(false));

    }

}
