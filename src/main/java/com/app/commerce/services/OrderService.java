package com.app.commerce.services;

import com.app.commerce.dbconnect.ConnectDB;
import com.app.commerce.entities.*;
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

    public List<OrderInformation> getOrdersForAdmin() throws SQLException {
        Connection con = ConnectDB.connect();
        List<OrderInformation> list = new ArrayList<>();
        String sql = "SELECT customer.customer_name, customer.customer_email, customer.customer_address, order_information.product_information, " +
                "order_information.total_price, order_information.order_status," +
                " order_information.order_id FROM order_information INNER JOIN customer ON order_information.customer_id = " +
                "customer.customer_id";

        PreparedStatement preparedStatement= con.prepareStatement(sql);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            OrderInformation information = new OrderInformation();
            information.setCustomerAddress(resultSet.getString("customer_address"));
            information.setCustomerEmail(resultSet.getString("customer_email"));
            information.setCustomerName(resultSet.getString("customer_name"));
            information.setProductInformation(resultSet.getString("product_information"));
            information.setProductPrice(resultSet.getDouble("total_price"));
            information.setOrderStatus(resultSet.getString("order_status"));
            information.setOrderId(resultSet.getInt("order_id"));
            list.add(information);
        }
        return list;
    }




}
