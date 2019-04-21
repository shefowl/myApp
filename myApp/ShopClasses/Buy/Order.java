package com.example.myApp.ShopClasses.Buy;

import com.example.myApp.exeptions.EmptyCartException;

public class Order {
    CartImpl userCart = new CartImpl();

    public Order(CartImpl userCart) throws EmptyCartException {
        this.userCart = userCart;
        if(this.userCart.isEmpty()) {
            throw new EmptyCartException();
        }
    }


}
