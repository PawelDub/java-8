package com.pivovarit.stacja;

import java.util.List;

public class Customer {

    private final List<Order> orders;

    public Customer(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
