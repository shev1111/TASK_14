package com.shev.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private  String client_login;
    private int cart_id;
    private int order_id;
    private Client client;
    private List<Order> orderList = new ArrayList<>();
    private int totalPrice =0;

    public Cart() {
    }

    public Cart(Client client) {
        this.client = client;
    }

    public Cart(String client_login, int cart_id, int order_id) {
        this.client_login = client_login;
        this.cart_id = cart_id;
        this.order_id = order_id;
    }

    public String getClient_login() {
        return client_login;
    }

    public void setClient_login(String client_login) {
        this.client_login = client_login;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getTotalPrice() {
        for (Order order:this.orderList) {
            this.totalPrice += order.getItemCount()*order.getItem().getPrice();
        }
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
