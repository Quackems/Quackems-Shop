package com.app.commerce.services;

import com.app.commerce.dbconnect.ConnectDB;
import com.app.commerce.entities.Cart;
import com.app.commerce.entities.CartInfo;
import com.app.commerce.entities.Customer;
import com.app.commerce.entities.Order;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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




        String sql1 = "INSERT INTO order_information values(null, ?, ?, ?, null)";
        PreparedStatement preparedStatement = con.prepareStatement(sql1);
        preparedStatement.setString(1, stringBuilder.toString());
        preparedStatement.setDouble(2, totalCost);
        preparedStatement.setInt(3, customer_id);
        boolean confirmOrder = preparedStatement.execute();

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

    public List<Order> getAllOrderInformation() throws SQLException {
        Connection con = ConnectDB.connect();
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM order_information WHERE customer_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, CustomerService.customerId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            Order customerOrder = new Order();
            customerOrder.setOrderId(resultSet.getInt("order_id"));
            customerOrder.setProductInformation(resultSet.getString("product_information"));
            customerOrder.setTotalCost(resultSet.getDouble("total_price"));
            customerOrder.setCustomer_id(resultSet.getInt("customer_id"));
            customerOrder.setOrderStatus(resultSet.getString("order_status"));
            list.add(customerOrder);
        }
        return list;
    }




}
