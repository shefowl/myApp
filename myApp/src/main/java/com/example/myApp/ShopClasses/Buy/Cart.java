package com.example.myApp.ShopClasses.Buy;

import javax.persistence.Embeddable;

@Embeddable
public class Cart {
    private ProductList userCart = new ProductList();
    public void addToCart(Product chosenProduct){
        userCart.addToList(chosenProduct);
    }
}
