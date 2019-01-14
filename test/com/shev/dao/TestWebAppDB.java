package com.shev.dao;

import com.shev.model.Cart;
import com.shev.model.Client;
import com.shev.model.Item;
import com.shev.model.Order;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestWebAppDB {

    @Test
    public void globalTest() throws Exception {
        Item test = new Item(0,"Test Item", 1111, 3);
        Item test_exp = ItemDAO.insertItem(test);
        assertTrue(test.getTitle().equals(test_exp.getTitle()));

        Client clientTest = new Client(0,"testClient", "test@gmail.com", "test");
        ClientDAO.insertClient(clientTest);

        Order insertOrderTest = OrderDAO.insertOrder(new Order(0,0, 2,"test@gmail.com"));

        Cart  cartTest = CartDAO.retrieveClientOrders(clientTest);
        assertTrue(cartTest.getOrderList().get(0).getItem().getTitle().equals(test.getTitle()));
        ClientDAO.deleteClient(clientTest);
        ItemDAO.deleteItem(test.getItemId());
        assertTrue(ItemDAO.retrieveItem(test.getItemId()).getTitle()==null);
        assertTrue(OrderDAO.retrieveOrder(insertOrderTest.getOrder_id()).getClient_login()==null);
        assertTrue(ClientDAO.retrieveClient(clientTest.getClientId()).getLogin()==null);

    }
}
