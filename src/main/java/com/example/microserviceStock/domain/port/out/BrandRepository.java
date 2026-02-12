package com.example.microserviceStock.domain.port.out;

import com.example.microserviceStock.domain.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandRepository {
    Brand saveBrand(Brand brand);
    Page<Brand> getAllBrand(Pageable pageable);
}
