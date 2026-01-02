package com.example.microserviceStock.domain.port.out;

import com.example.microserviceStock.adapter.out.persistence.CategoryEntity;
import com.example.microserviceStock.domain.model.Category;

import java.util.List;

public interface CategoryRepository {
    Category saveCategory(Category category);
    List<Category> findAll();
}
