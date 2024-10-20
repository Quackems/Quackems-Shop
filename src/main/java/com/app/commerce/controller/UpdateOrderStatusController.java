package com.app.commerce.controller;

import com.app.commerce.entities.OrderInformation;
import com.app.commerce.services.OrderService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class UpdateOrderStatusController {


    @FXML
    Button backToAdminDashboardBtn;

    @FXML
    Button updateOrderStatusBtn;

    @FXML
    TextArea orderStatusText;




    @FXML
    public void updateOrderStatus() throws SQLException {
        int orderId = AdminViewOrdersController.selectedOrderInformation.getOrderId();
        OrderService orderService = new OrderService();
        OrderInformation orderInformation = new OrderInformation(orderStatusText.getText());
        orderService.updateOrders(orderInformation, orderId);
    }

    @FXML
    public void backToAdminDashboard() throws IOException {
        Stage stage = (Stage) backToAdminDashboardBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/AdminDashboard.fxml")));
        stage.setScene(new Scene(root, 850, 600));
        stage.setTitle("Admin Dashboard");
    }

    @FXML
    public void initialize() {
        orderStatusText.setText(AdminViewOrdersController.selectedOrderInformation.getOrderStatus());
    }
}
