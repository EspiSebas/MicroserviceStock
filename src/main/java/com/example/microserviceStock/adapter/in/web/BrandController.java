package com.example.microserviceStock.adapter.in.web;

import com.example.microserviceStock.adapter.in.web.dto.BrandRequest;
import com.example.microserviceStock.domain.model.Brand;
import com.example.microserviceStock.domain.port.in.CreateBrandUseCase;
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
    public ResponseEntity<List<Brand>> getAllBrand(){
        return ResponseEntity.ok(createBrandUseCase.getAllBrand());
    }
}
