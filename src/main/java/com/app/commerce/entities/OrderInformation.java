package com.app.commerce.entities;

public class OrderInformation {

    private String customerName;

    private String customerAddress;

    private String customerEmail;

    private String productInformation;

    private double productPrice;

    private String orderStatus;

    private int orderId;


    public OrderInformation(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderInformation() {

    }

    public OrderInformation(String customerName, String customerAddress, String customerEmail,
                            String productInformation, double productPrice, String orderStatus, int orderId) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.productInformation = productInformation;
        this.productPrice = productPrice;
        this.orderStatus = orderStatus;
        this.orderId = orderId;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    @Override
    public String toString() {
        return "OrderInformation{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", productInformation='" + productInformation + '\'' +
                ", productPrice=" + productPrice +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
