package com.example.microserviceStock.adapter.in.web;

import com.example.microserviceStock.adapter.in.web.dto.CategoryRequest;
import com.example.microserviceStock.domain.model.Category;
import com.example.microserviceStock.domain.port.in.CreateCategoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase){
        this.createCategoryUseCase = createCategoryUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody CategoryRequest request){
        createCategoryUseCase.createCategory(request.getName(), request.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Category successfully created", HttpStatus.CREATED.value()));
    }

    @GetMapping("all")
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity.ok(createCategoryUseCase.getCategories());
    }
}
