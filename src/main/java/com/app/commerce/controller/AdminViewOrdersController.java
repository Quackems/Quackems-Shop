package com.app.commerce.controller;

import com.app.commerce.entities.OrderInformation;
import com.app.commerce.services.OrderService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class AdminViewOrdersController {

    @FXML
    Button backToAdminDashboardBtn;

    @FXML
    Button updateStatusBtn;

    @FXML
    TableColumn order_id_column;

    @FXML
    TableColumn customer_address_column;

    @FXML
    TableColumn customer_email_column;

    @FXML
    TableColumn product_information_column;

    @FXML
    TableColumn product_price_column;

    @FXML
    TableColumn order_status_column;

    @FXML
    TableColumn customer_name_column;

    @FXML
    TableView adminViewCustomerOrdersTable;


    static OrderInformation selectedOrderInformation;


    @FXML
    public void backToAdminDashboard() throws IOException {
        Stage stage = (Stage) backToAdminDashboardBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/AdminDashboard.fxml")));
        stage.setScene(new Scene(root, 850, 600));
        stage.setTitle("Admin Dashboard");
    }

    @FXML
    public void updateStatus() throws IOException {
        selectedOrderInformation = (OrderInformation) adminViewCustomerOrdersTable.getSelectionModel().getSelectedItem();

        if (selectedOrderInformation == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No Order is Selected!");
            alert.show();
        } else {
            Stage stage = (Stage) updateStatusBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/UpdateOrderStatus.fxml")));
            stage.setScene(new Scene(root, 700, 500));
            stage.setTitle("Update Order Status");
        }

    }


    public void initialize() throws SQLException {
        order_id_column.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        customer_address_column.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        customer_email_column.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
        product_information_column.setCellValueFactory(new PropertyValueFactory<>("productInformation"));
        product_price_column.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        order_status_column.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        customer_name_column.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        OrderService orderService = new OrderService();
        ObservableList<OrderInformation> list;
        list = FXCollections.observableList(orderService.getOrdersForAdmin());
        adminViewCustomerOrdersTable.setItems(list);
    }


}
