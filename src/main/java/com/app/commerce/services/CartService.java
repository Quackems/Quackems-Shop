package com.app.commerce.services;

import com.app.commerce.dbconnect.ConnectDB;
import com.app.commerce.entities.Cart;
import com.app.commerce.entities.CartInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */


public class CartService {


    public double totalCost;

    /**
     *
     * @param cart
     * @throws SQLException
     */

    public void addProductToCart(Cart cart) throws SQLException {
        String sql = "INSERT INTO cart VALUES (null, ?, ?)";

        Connection con = ConnectDB.connect();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, cart.getProductId());
        preparedStatement.setInt(2, cart.getCustomerId());

        preparedStatement.execute();
    }


    /**
     *
     * @return
     * @throws SQLException
     */

    public List<CartInfo> getAllCartInformation() throws SQLException {
        ArrayList<CartInfo> cartList = new ArrayList<>();
        int customerID = CustomerService.customerId;
        Connection con = ConnectDB.connect();
        String sql = "SELECT product.product_id, product.product_name, product.product_price, cart_id, product.product_description" +
                " FROM cart INNER JOIN product ON product.product_id = cart.product_id " +
                "WHERE customer_id = ?;";


        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, customerID);
        ResultSet resultSet = preparedStatement.executeQuery();
        double total = 0.0;
        while (resultSet.next()){
            CartInfo cartInfo = new CartInfo();
            cartInfo.setProductName(resultSet.getString("product_name"));
            cartInfo.setProductPrice(resultSet.getDouble("product_price"));
            cartInfo.setCartID(resultSet.getInt("cart_id"));
            cartInfo.setProductDescription(resultSet.getString("product_description"));
            total += resultSet.getDouble("product_price");
            cartList.add(cartInfo);
            totalCost = total;
        }
        con.close();
        return cartList;
    }


    /**
     *
     * @param cartId
     * @throws SQLException
     */


    public void removeCartItems(int cartId) throws SQLException {
        Connection con = ConnectDB.connect();

        String sql = "DELETE from cart WHERE cart_id = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, cartId);
        preparedStatement.execute();
    }

}
