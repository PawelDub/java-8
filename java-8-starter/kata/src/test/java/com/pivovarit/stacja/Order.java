package com.pivovarit.stacja;

public class Order {

    private final String name;

    public Order(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
          "name='" + name + '\'' +
          '}';
    }
}
