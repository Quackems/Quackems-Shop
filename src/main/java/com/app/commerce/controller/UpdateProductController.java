package com.app.commerce.controller;

import com.app.commerce.dbconnect.ConnectDB;
import com.app.commerce.entities.Product;
import com.app.commerce.services.ProductService;
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

public class UpdateProductController {
    @FXML
    Button backToAdminDashboardBtn;
    @FXML
    Button updateProductBtn;
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
    public void updateProduct() throws SQLException {
        Product product = new Product();

        ProductService productService = new ProductService();


        product.setProductName(addProductNameTxt.getText());

        product.setProductPrice(Double.parseDouble(addProductPriceTxt.getText()));

        product.setProductQuantity(Integer.parseInt(addProductQuantityTxt.getText()));

        product.setProductDescription(addProductDescriptionTxt.getText());


        productService.updateProduct(product);
    }

    @FXML
    public void initialize(){
        addProductNameTxt.setText(AdminDashboardController.selectedProduct.getProductName());
        addProductPriceTxt.setText(String.valueOf(AdminDashboardController.selectedProduct.getProductPrice()));
        addProductQuantityTxt.setText(String.valueOf(AdminDashboardController.selectedProduct.getProductQuantity()));
        addProductDescriptionTxt.setText(AdminDashboardController.selectedProduct.getProductDescription());
    }


}
