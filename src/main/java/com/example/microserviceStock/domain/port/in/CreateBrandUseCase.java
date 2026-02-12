package com.example.microserviceStock.domain.port.in;

import com.example.microserviceStock.domain.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CreateBrandUseCase {
    Brand createBrand(String name, String description);
    Page<Brand> getAllBrand(Pageable pageable);
}
