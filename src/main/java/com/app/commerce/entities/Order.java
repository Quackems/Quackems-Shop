package com.app.commerce.entities;

public class Order {

    private String orderInformation;

    private int orderId;

    private double totalCost;


    public Order() {

    }


    public Order(String orderInformation, int orderId, double totalCost) {
        this.orderInformation = orderInformation;
        this.orderId = orderId;
        this.totalCost = totalCost;
    }

    public String getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(String orderInformation) {
        this.orderInformation = orderInformation;
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
}