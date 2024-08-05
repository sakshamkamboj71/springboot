package com.initial.springboot.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    private int id;
    private String name;

    @Column(name = "description")
    private String desc;
    private int price;
    private String brand;
    private String category;
    private int stock;




    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + id +
                ", prodName='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
