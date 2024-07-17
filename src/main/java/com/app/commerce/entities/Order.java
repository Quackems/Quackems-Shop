package com.app.commerce.entities;

public class Order {

    private int orderId;
    private int productId;
    private int customerId;

    public Order(int productId, int customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
