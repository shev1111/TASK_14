package com.shev.dao;

import com.shev.model.Order;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {
    private static Logger logger = Logger.getLogger(OrderDAO.class.getName());

    public static Order insertOrder(Order order){
        String sql = "INSERT INTO orders (order_id, item_id, item_count, client_login) VALUES(?,?,?,?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1,order.getOrder_id());
            preparedStatement.setInt(2,order.getItemId());
            preparedStatement.setInt(3,order.getItemCount());
            preparedStatement.setString(4,order.getClient_login());
            preparedStatement.execute();
            logger.info("Order was inserted");
            return order;
        } catch (SQLException e) {
            logger.error("SQL error: " + e.getMessage());
        }
        logger.error("Order was not inserted");
        return new Order();
    }

    public static Order retrieveOrder(int order_id){
        String sql = "SELECT order_id, item_id, item_count, cart_id, times, client_login FROM orders WHERE order_id =?";
        Order order = new Order();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, order_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setOrder_id(resultSet.getInt("order_id"));
            order.setItemId(resultSet.getInt("item_id"));
            order.setItemCount(resultSet.getInt("item_count"));
            order.setTime(resultSet.getDate("times").getTime());
            order.setClient_login(resultSet.getString("client_login"));
            resultSet.close();
            logger.info("Order "+order.getOrder_id()+" was received");
            return order;
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.info("Order "+order.getOrder_id()+" was not received");
        return new Order();
    }

    public static Order updateOrder(Order order){
        String sql = "UPDATE orders SET item_id=?, item_count=?, client_login WHERE order_id =?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,order.getItemId());
            preparedStatement.setInt(2,order.getItemCount());
            preparedStatement.setString(3,order.getClient_login());
            preparedStatement.setInt(4,order.getOrder_id());
            preparedStatement.execute();
            logger.info("Order "+order.getOrder_id()+" was updated");
            return retrieveOrder(order.getOrder_id());
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.error("Order "+order.getOrder_id()+" was not updated");
        return new Order();
    }

    public static void deleteOrder(int order_id){
        String sql = "DELETE FROM orders WHERE order_id =?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, order_id);
            preparedStatement.execute();
            logger.info("Order "+order_id+" was deleted");
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
    }
}
