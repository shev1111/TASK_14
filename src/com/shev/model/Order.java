package com.shev.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Order {
    private int positionId;
    private int itemId;
    private int itemCount;
    private int cartId;
    private long time;
    private Cart cart;
    private Set items = new HashSet();
    private int orderTotalPrice;

    public Order() {
    }

    public Order(int positionId, int itemId, int itemCount, int cartId, long time) {
        this.positionId = positionId;
        this.itemId = itemId;
        this.itemCount = itemCount;
        this.cartId = cartId;
        this.time = time;
    }

    public Order(int itemId, int itemCount, int cartId) {
        this.itemId = itemId;
        this.itemCount = itemCount;
        this.cartId = cartId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
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

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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



}
