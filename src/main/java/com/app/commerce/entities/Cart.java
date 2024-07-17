package com.app.commerce.entities;

public class Cart {

    private int cartId;
    private int productId;
    private int customerId;

    public Cart(int productId, int customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }

    public Cart() {
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
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
