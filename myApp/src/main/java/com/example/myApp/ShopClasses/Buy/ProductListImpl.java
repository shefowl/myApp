package com.example.myApp.ShopClasses.Buy;

//import com.example.myApp.ShopClasses.Participants.User;

import java.util.ArrayList;
import java.util.List;

public class ProductListImpl implements ListActions {
    private List<Product> list = new ArrayList<Product>();
    @Override
    public void addToList(Product chosenProduct){
        list.add(chosenProduct);
    }
    @Override
    public void updateList (Product updateProduct){
        int index;
        index = list.indexOf(updateProduct);
        if(index == -1){

        }
        else {
            list.set(index, updateProduct);
        }
    }

    @Override
    public void deleteFromList(Product deleteProduct){
        list.remove(deleteProduct);
    }

    @Override
    public List<Product> showAllList() {
        return list;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public ProductListImpl() {
    }

    public ProductListImpl(List<Product> list) {
        this.list = list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public List<Product> getList() {
        return list;
    }
}
