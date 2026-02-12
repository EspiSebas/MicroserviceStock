package com.example.microserviceStock.domain.port.out;

import com.example.microserviceStock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryRepository {
    Category saveCategory(Category category);
    Page<Category> findAll(Pageable pageable);
}
