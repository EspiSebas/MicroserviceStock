package com.example.microserviceStock.adapter.in.web;

import com.example.microserviceStock.adapter.in.web.dto.BrandRequest;
import com.example.microserviceStock.adapter.in.web.dto.PageDtoResponse;
import com.example.microserviceStock.domain.model.Brand;
import com.example.microserviceStock.domain.model.Category;
import com.example.microserviceStock.domain.port.in.CreateBrandUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    private final CreateBrandUseCase createBrandUseCase;

    public BrandController(CreateBrandUseCase createBrandUseCase) {
        this.createBrandUseCase = createBrandUseCase;
    }

    @PostMapping("create")
    public ResponseEntity<ApiResponse> create(@RequestBody BrandRequest brandRequest){
        createBrandUseCase.createBrand(brandRequest.getName(), brandRequest.getDescription());

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Brand successfully created !!", HttpStatus.CREATED.value()));

    }

    @GetMapping("all")
    public PageDtoResponse<Brand> getAllBrand(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction

    ){
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Brand> pageResult = createBrandUseCase.getAllBrand(pageable);
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
