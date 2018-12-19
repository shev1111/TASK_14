package com.shev.dao;

import com.shev.model.Item;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {
    private static Logger logger = Logger.getLogger(ItemDAO.class.getName());

    public static Item insertItem(Item item){
        String sql = "INSERT INTO items (title, price, availability) VALUES(?,?,?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1,item.getTitle());
            preparedStatement.setInt(2,item.getPrice());
            preparedStatement.setInt(3,item.getAvailability());
            preparedStatement.execute();
            logger.info("Item  "+item.getTitle()+" was inserted");
            return item;
        } catch (SQLException e) {
            logger.error("SQL error: " + e.getMessage());
        }
        logger.error("Item  "+item.getTitle()+" was not inserted");
        return new Item();
    }

    public static Item retrieveItem(int item_id){
        String sql = "SELECT item_id, title, price, availability FROM items WHERE item_id =?";
        Item item = new Item();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,item_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            item.setItemId(resultSet.getInt("item_id"));
            item.setTitle(resultSet.getString("title"));
            item.setPrice(resultSet.getInt("price"));
            item.setAvailability(resultSet.getInt("availability"));
            resultSet.close();
            logger.info("Item "+item.getTitle()+" was received");
            return item;
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.info("Item "+item.getTitle()+" was not received");
        return new Item();
    }


    public static Item retrieveItemByTitle(String title){
        String sql = "SELECT item_id, title, price, availability FROM items WHERE title =?";
        Item item = new Item();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,title);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            item.setItemId(resultSet.getInt("item_id"));
            item.setTitle(resultSet.getString("title"));
            item.setPrice(resultSet.getInt("price"));
            item.setAvailability(resultSet.getInt("availability"));
            resultSet.close();
            logger.info("Item "+item.getTitle()+" was received");
            return item;
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.info("Item "+item.getTitle()+" was not received");
        return new Item();
    }

    public static Item updateItem(Item item){
        String sql = "UPDATE items SET title=?, price=?, availability =? WHERE item_id =?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,item.getTitle());
            preparedStatement.setInt(2,item.getPrice());
            preparedStatement.setInt(3, item.getAvailability());
            preparedStatement.setInt(4, item.getItemId());
            preparedStatement.execute();
            logger.info("Item "+item.getItemId()+" was updated");
            return retrieveItem(item.getItemId());
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.error("Item "+item.getItemId()+" was not updated");
        return new Item();
    }

    public static void deleteItem(int item_id){
        String sql = "DELETE FROM items WHERE item_id =?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1,item_id);
            preparedStatement.execute();
            logger.info("Item "+item_id+" was deleted");
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
    }
}
