package com.example.microserviceStock.domain.port.in;

import com.example.microserviceStock.domain.model.Category;

import java.util.List;

public interface CreateCategoryUseCase {
    Category createCategory(String name, String description);
    List<Category> getCategories();
}
