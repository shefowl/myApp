package com.example.myApp.ShopClasses.Participants;

import com.example.myApp.ShopClasses.Buy.Cart;
import com.example.myApp.ShopClasses.Buy.Product;

public class User extends ShopParticipant {
    Cart myCart = new Cart();
    public User(String userName, String password)
    {
        super(userName, password);
    }
    public void addToMyCart(Product chosenProduct){
        myCart.addToCart(chosenProduct);
    }
    public void showTheCatalog(){

    }
}
