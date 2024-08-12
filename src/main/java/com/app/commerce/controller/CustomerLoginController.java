package com.app.commerce.controller;

import com.app.commerce.dbconnect.ConnectDB;
import com.app.commerce.services.CustomerService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class CustomerLoginController {
    @FXML
    TextField email_txt;
    @FXML
    TextField password_txt;
    @FXML
    Button loginBtn;
    @FXML
    Button registerBtn;
    @FXML
    Button closeBtn;
    int customerId;

    public Stage stage;

    CustomerService customerService = new CustomerService();

    @FXML
    public void openMainMenu() throws IOException {
        stage = (Stage) closeBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/main.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Quackems Shop");
    }
    @FXML
    public void openRegistration() throws IOException {
        stage = (Stage) closeBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerRegistration.fxml")));
        stage.setScene(new Scene(root, 650, 600));
        stage.setTitle("Customer Registration");
    }
    @FXML
    public void customerLogIn() throws SQLException, IOException {
        String email = email_txt.getText();
        String password = password_txt.getText();
        Alert message = new Alert(Alert.AlertType.INFORMATION);
        Alert error = new Alert(Alert.AlertType.ERROR);

        if (customerService.customerAuthentication(email, password)){
            stage = (Stage) loginBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerDashboard.fxml")));
            stage.setScene(new Scene(root, 1000, 600));
            stage.setTitle("Customer dashboard");
        }
        else{
            error.setContentText("Login Unsuccessful!");
            error.show();
        }
    }
}
