package com.app.commerce.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CustomerDashboardController {

    Stage stage;
    @FXML
    Button customerLogOutBtn;

    @FXML
    public void customerLogOut() throws IOException {
        Stage stage = (Stage) customerLogOutBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerLogIn.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Registration");
    }

    public void openNewPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerLogin/fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage newStage = new Stage();
        newStage.setTitle("Customer Registration");
        newStage.setScene(scene);

        newStage.show();
    }
}
