package com.app.commerce.controller;

import com.app.commerce.entities.Order;
import com.app.commerce.services.OrderService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class CustomerViewOrdersController {

    Stage stage = new Stage();

    @FXML
    Button backToCustomerDashboardBtn;

    @FXML
    TableColumn order_id;

    @FXML
    TableColumn product_information;

    @FXML
    TableColumn total_price;

    @FXML
    TableColumn order_status;

    @FXML
    TableColumn customer_id;

    @FXML
    TableView customerViewOrdersTable;


    OrderService orderService = new OrderService();

    ObservableList<Order> orderList;




    @FXML
    public void backToCustomerDashboard() throws IOException {
        stage = (Stage) backToCustomerDashboardBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerDashboard.fxml")));
        stage.setScene(new Scene(root, 1000, 600));
        stage.setTitle("Customer dashboard");
    }


    public void initialize() throws SQLException {
        order_id.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        product_information.setCellValueFactory(new PropertyValueFactory<>("productInformation"));
        total_price.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        order_status.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        customer_id.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        orderList = FXCollections.observableList(orderService.getAllOrderInformation());
        customerViewOrdersTable.setItems(orderList);
    }


}
