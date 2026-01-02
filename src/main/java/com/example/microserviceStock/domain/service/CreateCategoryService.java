package com.example.microserviceStock.domain.service;

import com.example.microserviceStock.domain.model.Category;
import com.example.microserviceStock.domain.port.in.CreateCategoryUseCase;
import com.example.microserviceStock.domain.port.out.CategoryRepository;

import java.util.List;

public class CreateCategoryService implements CreateCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public CreateCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    @Override
    public Category createCategory(String name,String description){
        Category category = new Category(name, description);
        return categoryRepository.saveCategory(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }


}
