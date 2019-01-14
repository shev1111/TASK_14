package com.shev.dao;

import com.shev.model.Cart;
import com.shev.model.Client;
import com.shev.model.Item;
import com.shev.model.Order;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDAO {

    private static Logger logger = Logger.getLogger(CartDAO.class.getName());

    public static Cart retrieveClientOrders(Client client){
        String sql = "SELECT * from public.select_orders_by_login(?)";
        Cart cart = client.getCart();
        ArrayList<Order> orders = (ArrayList<Order>) cart.getOrderList();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,client.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Item item = new Item();
                Order order = new Order();
                item.setItemId(resultSet.getInt("item_id"));
                item.setTitle(resultSet.getString("title"));
                item.setPrice(resultSet.getInt("price"));
                order.setItem(item);
                order.setItemCount(resultSet.getInt("item_count"));
                order.setOrder_id(resultSet.getInt("order_id"));
                order.setClient_login(resultSet.getString("client_login"));
                order.setTime(resultSet.getDate("times").getTime());
                orders.add(order);
            }
            resultSet.close();
            logger.info("Cart of "+client.getLogin()+" was received");
            return cart;
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.error("Cart of "+client.getLogin()+" was not received");
        return cart;
    }
}
