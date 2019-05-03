package com.example.myApp.ShopClasses.Buy;

import com.example.myApp.exeptions.EmptyCartException;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int orderId;
    private float price;
    CartImpl userCart;// = new CartImpl();

    public Order() {
    }
    @JsonCreator
    public Order(CartImpl userCart) throws EmptyCartException {
        this.userCart = userCart;
        if(this.userCart.isEmpty()) {
            throw new EmptyCartException();
        }
    }

    public void countPrice(){ // тут можно JUnit
        List<Product> list = this.userCart.getUserCart().getList();
        for(Product element : list){
            this.price += element.getCost();
        }
    }

    public void makeDiscount(float discount){ // добавить эксепшн
        this.price -= discount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CartImpl getUserCart() {
        return userCart;
    }

    public void setUserCart(CartImpl userCart) {
        this.userCart = userCart;
    }
}
