package com.javahut.order;
//Represents an item that can be added to an order. Every item must know its price and description.
public interface LineItem {
    // returns total cost for this item
    double price();

    // returns readable summary for receipt
    String describe();

}
