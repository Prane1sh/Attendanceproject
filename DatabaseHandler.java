package project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String DATABASE_NAME = "auction.db";
    private static final String CONNECTION_URL = "jdbc:sqlite:" + DATABASE_NAME;

    private Connection connection;

    public DatabaseHandler() {
        try {
            // Update the database URL, username, and password accordingly
            String url = "jdbc:mysql://localhost:3306/navi";
            String username = "root";
            String password = "12345";

            
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTablesIfNotExist() {
        try (Statement statement = connection.createStatement()) {
            String createUserTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "username TEXT NOT NULL UNIQUE, " +
                    "password TEXT NOT NULL)";
            String createItemTableSQL = "CREATE TABLE IF NOT EXISTS items (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "description TEXT NOT NULL, " +
                    "starting_bid REAL NOT NULL, " +
                    "current_bid REAL NOT NULL, " +
                    "highest_bidder_id INTEGER)";

            statement.execute(createUserTableSQL);
            statement.execute(createItemTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String username, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User authenticateUser(String username, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                return new User(id, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addItem(String name, String description, double startingBid) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO items (name, description, starting_bid, current_bid, highest_bidder_id) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, startingBid);
            preparedStatement.setDouble(4, startingBid); // Set the current bid initially to the starting bid
            preparedStatement.setNull(5, Types.INTEGER); // Allow NULL for highest_bidder_id
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double startingBid = resultSet.getDouble("starting_bid");
                double currentBid = resultSet.getDouble("current_bid");
                int highestBidderId = resultSet.getInt("highest_bidder_id");
                items.add(new Item(id, name, description, startingBid, currentBid, highestBidderId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void updateItemBid(int itemId, double newBid, int newBidderId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE items SET current_bid = ?, highest_bidder_id = ? WHERE id = ?")) {
            preparedStatement.setDouble(1, newBid);
            preparedStatement.setInt(2, newBidderId);
            preparedStatement.setInt(3, itemId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
