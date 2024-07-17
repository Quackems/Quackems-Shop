package com.app.commerce.controller;

import com.app.commerce.dbconnect.ConnectDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class CustomerRegisterController {
    @FXML
    Button closeBtn;
    @FXML
    Button registerButton;
    @FXML
    TextField customerName;
    @FXML
    TextField customerEmail;
    @FXML
    TextField customerAddress;
    @FXML
    TextField customerPassword;
    @FXML
    TextField customerConfirmPassword;

    public Stage stage;
    @FXML
    public void openCustomerLogin() throws IOException {
        stage = (Stage) closeBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerLogIn.fxml")));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Customer Login");
    }



    @FXML
    public void createNewCustomer()throws SQLException{
        String customername = customerName.getText();
        String customeremail = customerEmail.getText();
        String customeraddress = customerAddress.getText();
        String customerpassword = customerPassword.getText();
        String customerconfirmpassword = customerConfirmPassword.getText();
        if (customername.isEmpty()||customeremail.isEmpty()||customeraddress.isEmpty()||customerpassword.isEmpty()||customerconfirmpassword.isEmpty()){
            message("Not all fields are filled!");
        }
        if (checkpassword(customerpassword, customerconfirmpassword)){
            message("Passwords don't match!");
        }
        String sql = "insert into customer values(null,?,?,?,?)";
        PreparedStatement statement = ConnectDB.connect().prepareStatement(sql);
        statement.setString(1,customername);
        statement.setString(2,customerpassword);
        statement.setString(3,customeremail);
        statement.setString(4,customeraddress);
        statement.execute();
        success("Registration Successful");
    }

    public boolean checkpassword(String firstpassword, String secondsPassword){
        boolean check = false;
        if (!firstpassword.equals(secondsPassword)){
            check = true;
        }
        return check;
    }
    public void message(String message){
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setContentText(message);
        error.show();
    }
    public void success(String message){
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setContentText(message);
        success.show();
    }
}
