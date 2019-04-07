package com.example.myApp.ShopClasses.Buy;

public class Product extends Cathegory {
    private String name;
    private float cost;

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }
}
