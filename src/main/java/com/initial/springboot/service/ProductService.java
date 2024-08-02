package com.initial.springboot.service;

import com.initial.springboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(new Product(101,"Iphone",1000), new Product(102, "Samsung", 900));

    public List<Product> getProducts(){
        return products;
    }

}
