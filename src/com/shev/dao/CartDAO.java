package com.shev.dao;

import com.shev.model.Cart;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDAO {

    private static Logger logger = Logger.getLogger(CartDAO.class.getName());

    public static Cart insertCart(Cart cart){
       /* String sql = "INSERT INTO cart (client_login) VALUES(?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1,cart);
            preparedStatement.execute();
            logger.info("Cart was inserted");
            return cart;
        } catch (SQLException e) {
            logger.error("SQL error: " + e.getMessage());
        }
        logger.error("Client was not inserted");*/
        return new Cart();
    }

    public static Cart retrieveCart(int order_id){
        /*String sql = "SELECT order_id, client_login FROM cart WHERE order_id =?";
        Cart cart = new Cart();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,order_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            cart.setOrderId(resultSet.getInt("position_id"));
            cart.setLogin(resultSet.getString("item_id"));
            resultSet.close();
            logger.info("Cart "+order_id+" was received");
            return cart;
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.info("Cart "+order_id+" was not received");*/
        return new Cart();
    }

    public static Cart updateCart(Cart cart){
        /*String sql = "UPDATE cart SET itclient_login=? WHERE order_id =?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,cart.getLogin());
            preparedStatement.setInt(2,order.getItemCount());
            preparedStatement.execute();
            logger.info("Order "+order.getPositionId()+" was updated");
            return retrieveOrder(order.getPositionId());
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.error("Order "+order.getPositionId()+" was not updated");*/
        return new Cart();
    }

    public static void deleteOrder(int position_id){
        /*String sql = "DELETE FROM orders WHERE position_id =?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, position_id);
            preparedStatement.execute();
            logger.info("Order "+position_id+" was deleted");
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }*/
    }
}
