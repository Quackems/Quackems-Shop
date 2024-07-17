package com.app.commerce.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection connect()throws SQLException {
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/quackemsshop","root","SaifMisk20092006@");
        System.out.println("Connection successful!");
        return con;
    }
}
