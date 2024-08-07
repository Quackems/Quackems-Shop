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

public class AddProductController {

    @FXML
    Button backToAdminDashboardBtn;
    @FXML
    Button addProductBtn;
    @FXML
    TextField addProductPriceTxt;
    @FXML
    TextField addProductQuantityTxt;
    @FXML
    TextField addProductNameTxt;
    @FXML
    TextField addProductDescriptionTxt;
    @FXML
    public void backToAdminDashboard() throws IOException {
        Stage stage = (Stage) backToAdminDashboardBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/AdminDashboard.fxml")));
        stage.setScene(new Scene(root, 850, 600));
        stage.setTitle("Admin Dashboard");
    }
    @FXML
    public void addProduct() throws SQLException {
        String productprice = addProductPriceTxt.getText();
        String productquantity = addProductQuantityTxt.getText();
        String productname = addProductNameTxt.getText();
        String productdescription = addProductDescriptionTxt.getText();
        Alert message = new Alert(Alert.AlertType.ERROR);
        Alert success = new Alert(Alert.AlertType.CONFIRMATION);
        if (productprice.isEmpty()||productquantity.isEmpty()||productname.isEmpty()||productdescription.isEmpty()){
            message.setContentText("Not all fields are filled!");
            message.show();
        }
        String sql = "insert into product values(null,?,?,?,?)";
        PreparedStatement statement = ConnectDB.connect().prepareStatement(sql);
        statement.setDouble(1,Double.parseDouble(productprice));
        statement.setInt(2, Integer.parseInt(productquantity));
        statement.setString(3,productname);
        statement.setString(4,productdescription);
        statement.execute();
        success.setContentText("Product Creation Success!");
        success.show();
    }
}
