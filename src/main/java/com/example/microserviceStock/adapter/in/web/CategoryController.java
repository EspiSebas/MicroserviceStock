package com.example.microserviceStock.adapter.in.web;

import com.example.microserviceStock.adapter.in.web.dto.CategoryRequest;
import com.example.microserviceStock.domain.model.Category;
import com.example.microserviceStock.domain.port.in.CreateCategoryUseCase;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase){
        this.createCategoryUseCase = createCategoryUseCase;
    }

    @PostMapping("/create")
    public Category create(@RequestBody CategoryRequest request){
        return createCategoryUseCase.createCategory(request.getName(), request.getDescription());
    }


}
