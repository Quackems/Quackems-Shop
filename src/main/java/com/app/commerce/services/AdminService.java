package com.app.commerce.services;

import com.app.commerce.dbconnect.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminService {

    public boolean adminAuthentication(String username, String password) throws SQLException {

        boolean login = false;
        Connection connect = ConnectDB.connect();
        String sql = "Select * from admin where admin_username = ? AND admin_password = ?";
        PreparedStatement statement = connect.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        while (result.next()){
            login = true;
        }
        return login;
    }


}
