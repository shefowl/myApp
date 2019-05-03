package com.example.myApp.ShopClasses.Buy;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
@Embeddable
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int productId;
    private String name;
    private float cost;
    private int number;

    public Product() {
    }
    @JsonCreator
    public Product(String name, float cost, int number) {
        this.name = name;
        this.cost = cost;
        this.number = number;
    }

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
