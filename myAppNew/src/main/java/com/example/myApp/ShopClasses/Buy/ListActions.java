package com.example.myApp.ShopClasses.Buy;

import java.util.List;

public interface ListActions {
    public void addToList(Product chosenProduct);
    public void updateList (Product updateProduct);
    public void deleteFromList(Product deleteProduct);
    public List<Product> showAllList();
    public boolean isEmpty();
}
