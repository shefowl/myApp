package com.example.myApp.ShopClasses.Buy;

public class Product {
    private String name;
    private float cost;
    private int number;

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }

    public int getNumber() { return number;}
}
