package com.app.commerce.controller;

import com.app.commerce.services.AdminService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AdminLoginController {
    @FXML
    TextField adminEmail_txt;
    @FXML
    TextField adminPassword_txt;
    @FXML
    Button adminLoginBtn;
    @FXML
    Button closeBtn;

    AdminService adminService = new AdminService();

    public Stage stage;

    @FXML
    public void openMainMenu() throws IOException {
        stage = (Stage) closeBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/main.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Quackems Shop");
    }

    @FXML
    public void adminLogin() throws IOException, SQLException {
        String username = adminEmail_txt.getText();
        String password = adminPassword_txt.getText();
        if (adminService.adminAuthentication(username,password)){
            stage = (Stage) closeBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/AdminDashboard.fxml")));
            stage.setScene(new Scene(root, 850, 600));
            stage.setTitle("Admin Dashboard");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Login details!");
            alert.show();
        }
    }

}
