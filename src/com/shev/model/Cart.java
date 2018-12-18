package com.shev.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int orderId;
    private  String login;
    private Client client;
    private List<Order> orderList = new ArrayList<>();
    private int totalPrice =0;


    public Cart() {
    }
    public Cart(Client client) {
        this.client = client;
    }

    public Cart(int orderId, String login) {
        this.orderId = orderId;
        this.login = login;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addOrder(Order order){
        orderList.add(order);
        //this.totalPrice = order.get11
        order.setCart(this);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
