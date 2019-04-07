package com.example.myApp.ShopClasses.Buy;

public class Cart {
    private ProductList userCart = new ProductList();
    public void addToCart(Product chosenProduct){
        userCart.addToList(chosenProduct);
    }
}
