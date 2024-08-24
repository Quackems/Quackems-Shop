package com.app.commerce.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CartController {


    Stage stage;

    @FXML
    Label totalCostLabel;

    @FXML
    Button backToCustomerDashboardBtn;


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






}
