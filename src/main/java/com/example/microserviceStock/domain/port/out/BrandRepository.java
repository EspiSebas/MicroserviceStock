package com.example.microserviceStock.domain.port.out;

import com.example.microserviceStock.domain.model.Brand;

import java.util.List;

public interface BrandRepository {
    Brand saveBrand(Brand brand);
    List<Brand> getAllBrand();
}
