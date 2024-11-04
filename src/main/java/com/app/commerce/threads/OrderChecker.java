package com.app.commerce.threads;

import com.app.commerce.controller.AdminDashboardController;
import com.app.commerce.dbconnect.ConnectDB;
import com.app.commerce.entities.Order;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderChecker implements Runnable{

    int lastCheck = 0;

    AdminDashboardController controller;
    public OrderChecker(AdminDashboardController controller) {
        this.controller = controller;
    }

    public void checkForNewOrders() throws SQLException {
        String sql = "SELECT * FROM order_information WHERE order_id > " + lastCheck;
        Connection con = ConnectDB.connect();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        boolean foundOrder = false;
        while (resultSet.next()) {
            lastCheck = resultSet.getInt("order_id");
            foundOrder = true;

        }
        if (foundOrder) {

            Platform.runLater(() ->{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("New Order");
                alert.show();
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            foundOrder = false;
        }
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
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
