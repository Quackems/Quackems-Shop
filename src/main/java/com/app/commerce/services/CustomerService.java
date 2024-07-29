package com.app.commerce.services;

import com.app.commerce.dbconnect.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerService {
    public int customerId;
    public boolean customerAuthentication(String email, String password) throws SQLException {

        boolean login = false;
        Connection connect = ConnectDB.connect();
        String sql = "Select * from customer where customer_email = ? AND customer_password = ?";
        PreparedStatement statement = connect.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        while (result.next()){
            login = true;
            customerId = result.getInt("customer_id");
        }
        return login;
    }

}
