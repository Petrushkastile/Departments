package service;

import java.sql.*;

public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "110119841";

    public static Connection getConnection() throws SQLException,ClassNotFoundException {
        Class.forName( "com.mysql.jdbc.Driver" );
        return DriverManager.getConnection( URL, USERNAME, PASSWORD );
    }
}
