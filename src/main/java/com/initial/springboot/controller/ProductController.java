package com.initial.springboot.controller;

import com.initial.springboot.model.Product;
import com.initial.springboot.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){

        Product p = service.getProductById(prodId);

        if(p != null)
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody Product prod){
        return service.addProduct(prod);
    }

    @PutMapping("/update-product/{prodId}")
    public void updateProduct(@RequestBody Product prod, @PathVariable int prodId){
        service.updateProduct(prod, prodId);
    }

    @DeleteMapping("/delete-product/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId){
        return service.deleteProduct(prodId);
    }

//    @GetMapping("/search-products/{keyword}")
//    public ResponseEntity<List<Product>> searchProducts(@PathVariable String keyword){
//        List<Product> p = service.searchProducts(keyword);
//        return new ResponseEntity<>(p, HttpStatus.OK);
//    }
}
