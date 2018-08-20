package service;

import java.sql.*;

public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "110119841";
    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            try {
                Class.forName( "com.mysql.jdbc.Driver" );
                connection = DriverManager.getConnection( URL, USERNAME, PASSWORD );
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
