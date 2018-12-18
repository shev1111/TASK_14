package com.shev.model;

public class Client {
    private int clientId;
    private String name;
    private String login;
    private String password;
    private Cart cart = new Cart(this);

    public Client() {
    }

    public Client(int clientId, String name, String login, String password) {
        this.clientId = clientId;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Client(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
