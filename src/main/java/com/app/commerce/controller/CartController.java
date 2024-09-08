package com.app.commerce.controller;

import com.app.commerce.entities.CartInfo;
import com.app.commerce.services.CartService;
import com.app.commerce.services.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class CartController {

    ObservableList<CartInfo> cartList;

    CartService cartService = new CartService();

    public double totalCost = cartService.totalCost;


    Stage stage;

    @FXML
    Label totalCostLabel;

    @FXML
    Button backToCustomerDashboardBtn;

    @FXML
    TableView cartTable;

    @FXML
    TableColumn productNameColumn;

    @FXML
    TableColumn productPriceColumn;

    @FXML
    TableColumn cartIdColumn;

    @FXML
    TableColumn productDescriptionColumn;


    @FXML
    public void backToCustomerDashboard() throws IOException {
        stage = (Stage) backToCustomerDashboardBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerDashboard.fxml")));
        stage.setScene(new Scene(root, 1000, 600));
        stage.setTitle("Customer dashboard");
    }



    @FXML
    public void initialize() throws SQLException {
        totalCostLabel.setText("Total Cost: $" + totalCost);
        CartService cartService = new CartService();
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        cartIdColumn.setCellValueFactory(new PropertyValueFactory<>("cartID"));
        productDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("productDescription"));


        cartList = FXCollections.observableList(cartService.getAllCartInformation());
        cartTable.setItems(cartList);
    }





}
