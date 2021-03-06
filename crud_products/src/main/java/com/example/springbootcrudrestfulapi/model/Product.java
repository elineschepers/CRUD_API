package com.example.springbootcrudrestfulapi.model;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;

    public Product(){}
    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
