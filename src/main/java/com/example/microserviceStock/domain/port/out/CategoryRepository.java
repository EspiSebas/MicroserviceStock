package com.example.microserviceStock.domain.port.out;

import com.example.microserviceStock.domain.model.Category;

public interface CategoryRepository {
    Category saveCategory(Category category);
}
