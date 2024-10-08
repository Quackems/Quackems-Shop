package com.app.commerce.services;

import com.app.commerce.dbconnect.ConnectDB;
import com.app.commerce.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    //fetch all product

    public List<Product> getAllProduct() throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * from product";
        Connection con = ConnectDB.connect();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()){
            Product product = new Product();
            product.setProductId(result.getInt("product_id"));
            product.setProductPrice(result.getDouble("product_price"));
            product.setProductDescription(result.getString("product_description"));
            product.setProductQuantity(result.getInt("product_quantity"));
            product.setProductName(result.getString("product_name"));
            products.add(product);
        }

        //Write the logic to loop through all the product details on the database
        return products;
    }

    public void deleteProduct(int productId) throws SQLException {
        Connection con = ConnectDB.connect();

        String sql = "DELETE from product WHERE product_id = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, productId);
        preparedStatement.execute();
    }

    public void updateProduct(Product product) throws SQLException{
        Connection con = ConnectDB.connect();

        String sql = "UPDATE product SET product_name = ?, product_price = ?, product_quantity = ?, product_description = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setDouble(2, product.getProductPrice());
        preparedStatement.setInt(3, product.getProductQuantity());
        preparedStatement.setString(4, product.getProductDescription());
        preparedStatement.execute();

    }


}
