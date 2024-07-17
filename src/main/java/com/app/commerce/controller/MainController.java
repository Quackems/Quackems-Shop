package com.app.commerce.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    @FXML
    Button customerBtn;

    @FXML
    Button adminBtn;
    @FXML
    public void openCustomer() throws IOException {
        Stage stage = (Stage) customerBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerLogIn.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Registration");
    }
    @FXML
    public void openAdmin() throws IOException {
        Stage stage = (Stage) adminBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/AdminLogIn.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Admin Login");
    }
}