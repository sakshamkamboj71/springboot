package com.initial.springboot.service;

import com.initial.springboot.model.Product;
import com.initial.springboot.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(new Product(101,"Iphone",1000), new Product(102, "Samsung", 900)));

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductById(int prodId){
        return repo.findById(prodId).orElse(new Product());
    }

    public ResponseEntity<String> addProduct(Product prod){
        repo.save(prod);

        return ResponseEntity.ok().body("Product added Successfully");
    }

    public void updateProduct(Product prod, int prodId) {
        Product p = repo.findById(prodId).orElse(null);

        if(p != null)
            repo.save(prod);
    }

    public ResponseEntity<String> deleteProduct(int prodId) {
        Product temp = repo.findById(prodId).orElse(null);

        if(temp == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");

        repo.deleteById(prodId);
        return ResponseEntity.ok().body("Product Deleted Successfully");
    }

//    public List<Product> searchProducts(String keyword) {
//        return repo.searchProducts(keyword);
//    }
}
