package com.initial.springboot.repository;

import com.initial.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

//    @Query("SELECT prod FROM PRODUCTS prod WHERE LOWER(prod.name) LIKE LOWER(CONCAT('%', :keyword,'%'))")
//    List<Product> searchProducts(String keyword);
}
