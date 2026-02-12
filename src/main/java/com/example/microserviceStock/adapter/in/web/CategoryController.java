package com.example.microserviceStock.adapter.in.web;

import com.example.microserviceStock.adapter.in.web.dto.CategoryRequest;
import com.example.microserviceStock.adapter.in.web.dto.PageDtoResponse;
import com.example.microserviceStock.domain.model.Category;
import com.example.microserviceStock.domain.port.in.CreateCategoryUseCase;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PageDtoResponse<Category> getCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction

            ){

        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Category> pageResult = createCategoryUseCase.getCategories(pageable);

        return new PageDtoResponse<>(
                pageResult.getContent(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isLast()
        );
    }

}
