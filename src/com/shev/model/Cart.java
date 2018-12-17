package com.shev.model;

public class Cart {
    private int orderId;
    private  String login;

    public Cart() {
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
}
