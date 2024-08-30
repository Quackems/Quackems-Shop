package com.app.commerce.entities;

public class CartInfo {

    String productName;
    double productPrice;
    int cartID;
    String productDescription;

    public CartInfo(){

    }


    public CartInfo(String productName, double productPrice, int cartID, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.cartID = cartID;
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "CartInfo{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", cartID=" + cartID +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
