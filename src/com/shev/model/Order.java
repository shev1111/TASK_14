package com.shev.model;


public class Order {
    private int order_id;
    private int itemId;
    private int itemCount;
    private long time;
    private Item item;
    private String client_login;

    public Order() {
    }

    public Order(int order_id, int itemId, int itemCount, long time) {
        this.order_id = order_id;
        this.itemId = itemId;
        this.itemCount = itemCount;
        this.time = time;
    }

    public Order(int order_id, int itemId, int itemCount) {
        this.order_id = order_id;
        this.itemId = itemId;
        this.itemCount = itemCount;
    }

    public Order(int order_id, int itemId, int itemCount, String client_login) {
        this.order_id = order_id;
        this.itemId = itemId;
        this.itemCount = itemCount;
        this.client_login = client_login;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getClient_login() {
        return client_login;
    }

    public void setClient_login(String client_login) {
        this.client_login = client_login;
    }
}
