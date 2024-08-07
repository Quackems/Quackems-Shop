package com.app.commerce.entities;

public class Product {

    private int productId;
    private double productPrice;
    private int productQuantity;
    private String productName;
    private String productDescription;

    public Product(double productPrice, int productQuantity, String productName, String productDescription) {
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
