package com.example.microserviceStock.domain.port.in;

import com.example.microserviceStock.domain.model.Category;

public interface CreateCategoryUseCase {
    Category createCategory(String name, String description);
}
