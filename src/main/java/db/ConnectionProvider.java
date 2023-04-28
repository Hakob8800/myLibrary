package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private final static ConnectionProvider INSTANCE = new ConnectionProvider();
    private Connection connection;
    private final static String URL = "jdbc:mysql://localhost:3306/mylibrary?useUnicode=true";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private ConnectionProvider() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionProvider getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}