package com.example.microserviceStock.domain.port.in;

import com.example.microserviceStock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CreateCategoryUseCase {
    Category createCategory(String name, String description);
    Page<Category> getCategories(Pageable pageable);
}
