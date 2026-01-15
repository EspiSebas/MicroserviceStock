package com.example.microserviceStock.domain.model;

import com.example.microserviceStock.adapter.out.persistence.BrandEntity;
import com.example.microserviceStock.adapter.out.persistence.CategoryEntity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Article {
    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;
    private Long brand;
    private Set<Long> categories = new HashSet<>();


    public Article(String name, String description, int quantity, BigDecimal price, Long brand,Set<Long> categories) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.brand = brand;
        this.categories = categories != null ? categories : new HashSet<>();;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Long> getCategories() {
        return categories;
    }

    public void setCategories(Set<Long> categories) {
        this.categories = categories;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }
}
