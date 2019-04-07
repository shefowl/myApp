package com.example.myApp.ShopClasses.Buy;

import com.example.myApp.ShopClasses.Participants.User;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<Product> list = new ArrayList<Product>();
    public void addToList(Product chosenProduct){
        list.add(chosenProduct);
    }
}
