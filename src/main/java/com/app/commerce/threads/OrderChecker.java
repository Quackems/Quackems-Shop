package com.app.commerce.threads;

import com.app.commerce.dbconnect.ConnectDB;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderChecker implements Runnable{

    int lastCheck = 0;

    public String orderMessage = "";

    public void checkForNewOrders() throws SQLException {
        String sql = "SELECT * FROM order_information WHERE order_id >" + lastCheck;
        Connection con = ConnectDB.connect();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            orderMessage = "New Order";
            lastCheck = resultSet.getInt("order_id");
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                checkForNewOrders();
                Thread.sleep(5000);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
