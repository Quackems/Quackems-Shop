package com.app.commerce.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminLoginController {
    @FXML
    TextField adminEmail_txt;
    @FXML
    TextField adminPassword_txt;
    @FXML
    Button adminLogin;
    @FXML
    Button closeBtn;

    public Stage stage;

    @FXML
    public void openMainMenu() throws IOException {
        stage = (Stage) closeBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/main.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Quackems Shop");
    }
}
