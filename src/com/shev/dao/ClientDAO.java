package com.shev.dao;

import com.shev.model.Client;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    private static Logger logger = Logger.getLogger(ClientDAO.class.getName());

    public static Client insertClient(Client client){
        String sql = "INSERT INTO client (client_id, pass, login, name) VALUES(?,?,?,?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1,client.getClientId());
            preparedStatement.setString(2,client.getPassword());
            preparedStatement.setString(3,client.getLogin());
            preparedStatement.setString(4,client.getName());
            preparedStatement.execute();
            logger.info("Client  "+client.getLogin()+" was inserted");
            return client;
        } catch (SQLException e) {
            logger.error("SQL error: " + e.getMessage());
        }
        logger.error("Client  "+client.getLogin()+" was not inserted");
        return new Client();
    }

    public static Client retrieveClient(int client_id){
        String sql = "SELECT name, login, pass, client_id FROM client WHERE client_id =?";
        Client client = new Client();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,client_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            client.setName(resultSet.getString("name"));
            client.setLogin(resultSet.getString("login"));
            client.setPassword(resultSet.getString("pass"));
            client.setClientId(resultSet.getInt("client_id"));
            resultSet.close();
            logger.info("Client "+client.getLogin()+" was received");
            return client;
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.info("Client "+client_id+" was not received");
        return new Client();
    }


    public static Client updateClient(Client client){
        String sql = "UPDATE client SET name=?, pass=? WHERE client_id =?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,client.getName());
            preparedStatement.setString(2,client.getPassword());
            preparedStatement.execute();
            logger.info("Client "+client.getLogin()+" was updated");
            return retrieveClient(client.getClientId());
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        logger.error("Client "+client.getLogin()+" was not updated");
        return new Client();
    }

    public static void deleteClient(Client client){
        String sql = "DELETE FROM client WHERE client_id =?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1,client.getClientId());
            preparedStatement.execute();
            logger.info("Client "+client.getLogin()+" was deleted");
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
    }
}
