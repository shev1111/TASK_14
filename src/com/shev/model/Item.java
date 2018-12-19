package com.shev.model;

public class Item {
    private int itemId;
    private String title;
    private int price;
    private int availability;
    private int itemsOrderCount;

    public Item() {
    }


    public Item( String title, int price, int count) {
        this.title = title;
        this.price = price;
        this.availability = count;
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

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getItemsOrderCount() {
        return itemsOrderCount;
    }

    public void setItemsOrderCount(int itemsOrderCount) {
        this.itemsOrderCount = itemsOrderCount;
    }
}

