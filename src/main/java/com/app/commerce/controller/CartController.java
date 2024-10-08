package com.app.commerce.controller;

import com.app.commerce.entities.CartInfo;
import com.app.commerce.services.CartService;
import com.app.commerce.services.OrderService;
import com.app.commerce.services.ProductService;
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

public class CartController {

    ObservableList<CartInfo> cartList;

    CartService cartService = new CartService();

    public double totalCost = cartService.totalCost;


    Stage stage;

    @FXML
    Label totalCostLabel;

    @FXML
    Button backToCustomerDashboardBtn;

    @FXML
    Button deleteCartContentBtn;

    @FXML
    Button checkOutBtn;

    @FXML
    TableView cartTable;

    @FXML
    TableColumn productNameColumn;

    @FXML
    TableColumn productPriceColumn;

    @FXML
    TableColumn cartIdColumn;

    @FXML
    TableColumn productDescriptionColumn;


    @FXML
    public void backToCustomerDashboard() throws IOException {
        stage = (Stage) backToCustomerDashboardBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/app/commerce/CustomerDashboard.fxml")));
        stage.setScene(new Scene(root, 1000, 600));
        stage.setTitle("Customer dashboard");
    }


    @FXML
    public void deleteCartContent() throws SQLException {
        CartInfo cartInfo = (CartInfo) cartTable.getSelectionModel().getSelectedItem();

        if (cartInfo != null) {
            Alert deleteConfirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this product", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            deleteConfirm.showAndWait();
            if (deleteConfirm.getResult() == ButtonType.YES) {
                cartService.removeCartItems(cartInfo.getCartID());
                cartList.remove(cartInfo);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No Item Selected!");
            alert.show();
        }

    }



    @FXML
    public void checkOut() throws SQLException {
        Alert confirmCheckOut = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you would like to check out?", ButtonType.YES, ButtonType.NO, ButtonType.CLOSE);
        confirmCheckOut.showAndWait();
        if (confirmCheckOut.getResult() == ButtonType.YES) {
            Alert confirmed = new Alert(Alert.AlertType.INFORMATION);
            confirmed.setContentText("Your order has been placed");
            confirmed.show();
            OrderService orderService = new OrderService();
            orderService.addOrder();
        }
    }




    @FXML
    public void initialize() throws SQLException {
        totalCostLabel.setText("Total Cost: $" + totalCost);
        CartService cartService = new CartService();
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        cartIdColumn.setCellValueFactory(new PropertyValueFactory<>("cartID"));
        productDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("productDescription"));


        cartList = FXCollections.observableList(cartService.getAllCartInformation());
        cartTable.setItems(cartList);
    }





}
