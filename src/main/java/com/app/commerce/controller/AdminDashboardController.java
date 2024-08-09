package com.app.commerce.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminDashboardController {

    @FXML
    Button adminAddProductBtn;
    @FXML
    Button deleteProductBtn;
    @FXML
    Button viewCustomersBtn;
    @FXML
    Button updateProductBtn;
    @FXML
    Button viewOrdersBtn;
    @FXML
    Button adminLogOutBtn;

    @FXML
    public void adminLogOut() throws IOException {
        Stage stage = (Stage) adminLogOutBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/AdminLogin.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Admin Login");
    }
    @FXML
    public void adminAddProduct() throws IOException {
        Stage stage = (Stage) adminAddProductBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/AddProduct.fxml")));
        stage.setScene(new Scene(root, 800, 600));
        stage.setTitle("Add product");
    }

    //Make use of observableList to display all product in a table

}
