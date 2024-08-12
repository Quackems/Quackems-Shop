package com.app.commerce.controller;

import com.app.commerce.entities.Product;
import com.app.commerce.services.ProductService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
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
    TableView <Product>productTable;
    @FXML
    TableColumn <Product, Integer>productIdColumn;
    @FXML
    TableColumn <Product, String>productNameColumn;
    @FXML
    TableColumn <Product, Double>productPriceColumn;
    @FXML
    TableColumn <Product, Integer>productQuantityColumn;
    @FXML
    TableColumn <Product, String>productDescriptionColumn;


    ObservableList<Product> productList;


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
    @FXML
    public void initialize() throws SQLException {
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
        productDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("productDescription"));

        ProductService productService = new ProductService();
        productList = FXCollections.observableList(productService.getAllProduct());
        productTable.setItems(productList);
    }

    //Make use of observableList to display all product in a table

}
