package com.app.commerce.entities;

public class Order {

    private String productInformation;

    private int orderId;

    private double totalCost;

    private int customer_id;

    private String orderStatus;


    public Order() {

    }


    public Order(String orderInformation, int orderId, double totalCost, int customer_id, String orderStatus) {
        this.productInformation = orderInformation;
        this.orderId = orderId;
        this.totalCost = totalCost;
        this.customer_id = customer_id;
        this.orderStatus = orderStatus;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productInformation='" + productInformation + '\'' +
                ", orderId=" + orderId +
                ", totalCost=" + totalCost +
                ", customer_id=" + customer_id +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}