package com.jdbc;

public class Product {
    private int id;
    private String name;
    private double price;
    private int shopID;

    public Product() {}

    public Product(int id, String name, double price, int shopID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shopID = shopID;
    }

    @Override
    public String toString() {
        return "Product: [" + id + "\t" + name + "\t" + price + " руб" + "\t" + shopID + "]";
    }
}
