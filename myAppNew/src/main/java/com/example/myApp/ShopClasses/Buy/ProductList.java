package com.example.myApp.ShopClasses.Buy;

//import com.example.myApp.ShopClasses.Participants.User;

import com.example.myApp.ShopClasses.Participants.User;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

public class ProductList {
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Product> list = new ArrayList<Product>();
    public void addToList(Product chosenProduct){
        list.add(chosenProduct);
    }
}
