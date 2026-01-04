package com.example.microserviceStock.domain.port.in;

import com.example.microserviceStock.domain.model.Brand;

import java.util.List;

public interface CreateBrandUseCase {
    Brand createBrand(String name, String description);
    List<Brand> getAllBrand();
}
