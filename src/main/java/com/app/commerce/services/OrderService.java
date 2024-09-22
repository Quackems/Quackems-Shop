package com.app.commerce.services;

import com.app.commerce.dbconnect.ConnectDB;
import com.app.commerce.entities.Cart;
import com.app.commerce.entities.CartInfo;
import com.app.commerce.entities.Customer;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderService {


    public void addOrder() throws SQLException {

        CartService cartService = new CartService();

        int customer_id = CustomerService.customerId;

        Connection con = ConnectDB.connect();

        ArrayList<CartInfo> cartList = (ArrayList<CartInfo>) cartService.getAllCartInformation();

        StringBuilder stringBuilder = new StringBuilder();

        double totalCost = cartService.totalCost;

        for (CartInfo cart: cartList){

            stringBuilder.append("product_name: " + cart.getProductName()+ "\n");
            stringBuilder.append("product_price: " + cart.getProductPrice()+ "\n");
            stringBuilder.append("product_description: " + cart.getProductDescription()+ "\n");
        }




        String sql1 = "INSERT INTO order_information values(null, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql1);
        preparedStatement.setString(1, stringBuilder.toString());
        preparedStatement.setDouble(2, totalCost);
        boolean confirmOrder = preparedStatement.execute();
        System.out.println(preparedStatement.execute());

        if (!confirmOrder){
            String sql2 = "DELETE FROM cart WHERE customer_id = ?";
            PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
            preparedStatement2.setInt(1, customer_id);
            preparedStatement2.execute();
        }
        if (confirmOrder) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error Encountered");
            alert.show();
        }
    }


}
