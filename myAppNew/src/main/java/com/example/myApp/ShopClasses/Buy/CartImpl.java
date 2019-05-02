package com.example.myApp.ShopClasses.Buy;

import javax.persistence.Embeddable;
import java.util.List;
@Embeddable
public class CartImpl implements ListActions {
    private ProductListImpl userCart;// = new ProductListImpl();
    @Override
    public void addToList(Product chosenProduct){
        userCart.addToList(chosenProduct);
    }

    @Override
    public void updateList(Product updateProduct) {
        userCart.updateList(updateProduct);
    }

    @Override
    public void deleteFromList(Product deleteProduct) {
        userCart.deleteFromList(deleteProduct);
    }

    @Override
    public List<Product> showAllList() {
        return userCart.showAllList();
    }

    @Override
    public boolean isEmpty() {
        return userCart.isEmpty();
    }

    public void setUserCart(ProductListImpl userCart) {
        this.userCart = userCart;
    }

    public ProductListImpl getUserCart() {
        return userCart;
    }

    public CartImpl() {
        userCart = new ProductListImpl();
    }

    public CartImpl(ProductListImpl userCart) {
        this.userCart = userCart;
    }

}
