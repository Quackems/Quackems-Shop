package com.app.commerce.services;

import com.app.commerce.dbconnect.ConnectDB;
import com.app.commerce.entities.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartService {
    public void addProductToCart(Cart cart) throws SQLException {
        String sql = "INSERT INTO cart VALUES (null, ?, ?)";

        Connection con = ConnectDB.connect();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, cart.getProductId());
        preparedStatement.setInt(2, cart.getCustomerId());

        preparedStatement.execute();
    }

    public void getAllCartInformation() throws SQLException {
        Connection con = ConnectDB.connect();
        String sql = "SELECT product.product_id, product.product_name, cart_id, product.product_description" +
                " FROM cart INNER JOIN product ON product.product_id = cart.product_id " +
                "WHERE customer_id = ?;";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
    }

}
