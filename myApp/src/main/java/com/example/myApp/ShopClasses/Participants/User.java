package com.example.myApp.ShopClasses.Participants;

import com.example.myApp.ShopClasses.Buy.CartImpl;
import com.example.myApp.ShopClasses.Buy.Product;
import com.example.myApp.exeptions.EmptyCartException;

import java.util.List;

public class User extends ShopParticipant {
    CartImpl myCart = new CartImpl();
    public User(String userName, String password)
    {
        super(userName, password);
    }
    public void addToMyCart(Product chosenProduct){
        myCart.addToList(chosenProduct);
    }
    public void showTheCatalog(){

    }
    public List<Product> showMyCart() throws EmptyCartException{
        if(this.myCart.isEmpty()){
            throw new EmptyCartException();
        }
       return myCart.showAllList();
    }

    public void buy(){

    }
}
