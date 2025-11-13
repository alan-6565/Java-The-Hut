package com.javahut.order;

public class Side implements LineItem{
    private String name;
    private double price;

    public Side(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public double price() {
        return price;
    }

    @Override
    public String describe() {
        return name + " $" + String.format("%.2f", price());
    }
}
