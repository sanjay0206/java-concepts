package com.corejava.java8.funcinterface.items;

public class Item {

    private String itemName;
    private int price;

    public Item() {

    }

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public Item(String itemName, int price) {
        super();
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [itemName=" + itemName + ", price=" + price + "]";
    }

}
