package com.initial.springboot.model;


import org.springframework.stereotype.Component;

@Component
public class Product {
    private int prodId;
    private String prodName;
    private int price;

    public Product(){}


    public Product(int prodId, String prodName, int price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }

    public int getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public int getPrice() {
        return price;
    }
}
