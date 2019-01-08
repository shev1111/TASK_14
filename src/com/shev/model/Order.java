package com.shev.model;

import java.util.HashSet;
import java.util.Set;

public class Order {
    private int order_id;
    private int itemId;
    private int itemCount;
    private long time;
    private String client_login;
    private Set items = new HashSet();
    private int orderTotalPrice=0;

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

    public Set getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
        this.orderTotalPrice +=(item.getPrice()*item.getItemsOrderCount());
    }

    public void deleteItem(Item item) {
        items.remove(item);
    }

    public String getClient_login() {
        return client_login;
    }

    public void setClient_login(String client_login) {
        this.client_login = client_login;
    }
}
