package com.shev.model;

public class Item {
    private int itemId;
    private String title;
    private int price;
    private int count;

    public Item() {
    }


    public Item(int itemId, String title, int price, int count) {
        this.itemId = itemId;
        this.title = title;
        this.price = price;
        this.count = count;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
