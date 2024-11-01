package com.app.commerce.controller;

import com.app.commerce.entities.Order;
import com.app.commerce.entities.Product;
import com.app.commerce.services.AdminService;
import com.app.commerce.services.OrderService;
import com.app.commerce.services.ProductService;
import com.app.commerce.threads.OrderChecker;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AdminDashboardController {

    OrderChecker orderChecker = new OrderChecker();
    Thread thread = new Thread(orderChecker);


    static Product selectedProduct;

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
//        thread.stop();
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
    public void deleteProduct() throws SQLException {
        Product product = productTable.getSelectionModel().getSelectedItem();
        if (product != null) {
            ProductService productService = new ProductService();
            productService.deleteProduct(product.getProductId());


            Alert deleteConfirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this product", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            deleteConfirm.showAndWait();
            if (deleteConfirm.getResult() == ButtonType.YES) {
                productList.remove(product);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No Product Selected!");
            alert.show();
        }
    }



    @FXML
    public void updateProduct() throws IOException {
        selectedProduct = productTable.getSelectionModel().getSelectedItem();

        if (selectedProduct == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No Product Selected!");
            alert.show();
        } else {
            Stage stage = (Stage) updateProductBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/updateProduct.fxml")));
            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("Update product");
        }
    }

    @FXML
    public void viewOrders() throws SQLException, IOException {
        Stage stage = (Stage) viewOrdersBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/AdminViewOrders.fxml")));
        stage.setScene(new Scene(root, 1000, 700));
        stage.setTitle("Admin View Orders");
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


        thread.start();
        if (!orderChecker.orderMessage.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(orderChecker.orderMessage);
            alert.show();
        }
    }
}
